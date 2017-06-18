package com.techgarden.tasks.payu.client;

import com.techgarden.tasks.payu.client.request.LogHttpRequestAndResponseInterceptor;
import com.techgarden.tasks.payu.client.request.OrderCreateRequest;
import com.techgarden.tasks.payu.client.request.entities.*;
import com.techgarden.tasks.payu.client.response.OrderCreateResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class PayUClientIntegrationTest {

    private static final String SANDBOX_CREATE_ORDER_URL = "https://secure.snd.payu.com/api/v2_1/orders";

    private static final String SANDBOX_AUTHORIZATION_TOKEN = "d9a4536e-62ba-4f60-8017-6053211d3f47";

    private static PayUClient client;

    private static RestTemplate getLoggingRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.setInterceptors(singletonList(new LogHttpRequestAndResponseInterceptor()));
        return restTemplate;
    }

    @BeforeClass
    public static void beforeClass() {
        client = new PayUClient(getLoggingRestTemplate(), SANDBOX_CREATE_ORDER_URL);
    }

    @Test
    public void shouldCreateOrderCorrectlyWithOnlyRequiredFields() {
        // given
        OrderCreateRequest order = new OrderCreateRequest.Builder()
                .notifyUrl("https://your.eshop.com/notify")
                .customerIp("127.0.0.1")
                .merchantPosId(300746L)
                .description("Zakup testowy")
                .currencyCode(OrderCreateRequest.CurrencyCode.PLN)
                .totalAmount(21000L)
                .products(productWithRequiredData())
                .build();

        // when
        OrderCreateResponse response = client.createOrder(order, SANDBOX_AUTHORIZATION_TOKEN);

        // then
        assertThat(response.isValid()).isTrue();
        assertThat(response.getExtOrderId()).isNull();
    }

    @Test
    public void shouldCreateOrderCorrectlyWithAllParamsAndShippingMethodSet() {
        // given
        String extOrderId = UUID.randomUUID().toString();

        OrderCreateRequest order = new OrderCreateRequest.Builder()
                .notifyUrl("https://your.eshop.com/notify")
                .customerIp("127.0.0.1")
                .merchantPosId(300746L)
                .description("Zakup testowy")
                .currencyCode(OrderCreateRequest.CurrencyCode.PLN)
                .totalAmount(21000L)
                .products(productWithAllData())
                .orderUrl("https://your.eshop.com/123456789")
                .continueUrl("https://your.eshop.com/continueUrl")
                .validityTime(60L)
                .additionalDescription("Zakup testowy 2")
                .extOrderId(extOrderId)
                .settings(new Settings(true))
                .buyer(buyerWithAllData())
                .shippingMethods(shippingMethodWithAllData())
                .build();

        // when
        OrderCreateResponse response = client.createOrder(order, SANDBOX_AUTHORIZATION_TOKEN);

        // then
        assertThat(response.isValid()).isTrue();
        assertThat(response.getExtOrderId()).isEqualTo(extOrderId);
    }

    @Test
    public void shouldCreateOrderCorrectlyWithAllParamsAndPayMethodMethodSet() {
        // given
        String extOrderId = UUID.randomUUID().toString();

        OrderCreateRequest order = new OrderCreateRequest.Builder()
                .notifyUrl("https://your.eshop.com/notify")
                .customerIp("127.0.0.1")
                .merchantPosId(300746L)
                .description("Zakup testowy")
                .currencyCode(OrderCreateRequest.CurrencyCode.PLN)
                .totalAmount(21000L)
                .products(productWithAllData())
                .orderUrl("https://your.eshop.com/123456789")
                .continueUrl("https://your.eshop.com/continueUrl")
                .validityTime(60L)
                .additionalDescription("Zakup testowy 2")
                .extOrderId(extOrderId)
                .settings(new Settings(true))
                .buyer(buyerWithAllData())
                .payMethod(payMethodWithAllData())
                .build();

        // when
        OrderCreateResponse response = client.createOrder(order, SANDBOX_AUTHORIZATION_TOKEN);

        // then
        assertThat(response.isValid()).isTrue();
        assertThat(response.getExtOrderId()).isEqualTo(extOrderId);
    }

    private Delivery deliveryWithAllData() {
        return new Delivery.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz")
                .postalBox("87-123")
                .name("XXX")
                .recipientEmail("mmaszkie@gmail.com")
                .recipientPhone("123456789")
                .state("pomorskie")
                .build();
    }

    private Invoice invoiceWithAllData() {
        return new Invoice.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz")
                .postalBox("87-123")
                .name("XXX")
                .recipientEmail("mmaszkie@gmail.com")
                .recipientPhone("123456789")
                .state("pomorskie")
                .tin("123456789")
                .eInvoiceRequested(true)
                .build();
    }

    private Billing billingWithAllData() {
        return new Billing.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz")
                .postalBox("87-123")
                .name("XXX")
                .recipientEmail("mmaszkie@gmail.com")
                .recipientPhone("123456789")
                .state("pomorskie")
                .build();
    }

    private Buyer buyerWithAllData() {
        return new Buyer.Builder()
                .email("mmaszkie@gmail.com")
                .phone("12345689")
                .firtName("Mateusz")
                .lastName("Maszkiewicz")
                .language(Buyer.Language.pl)
                .extCustomerId("1234567890")
                .nin("123")
                .customerId("123456789")
                .delivery(deliveryWithAllData())
                .invoice(invoiceWithAllData())
                .billing(billingWithAllData())
                .build();
    }

    private Product productWithRequiredData() {
        return new Product.Builder()
                .name("RTV")
                .unitPrice(21000L)
                .quantity(1L)
                .build();
    }

    private Product productWithAllData() {
        return new Product.Builder()
                .name("RTV")
                .unitPrice(21000L)
                .quantity(1L)
                .virtual(true)
                .listingDate(ZonedDateTime.now())
                .build();
    }

    private ShippingMethod shippingMethodWithAllData() {
        return new ShippingMethod.Builder()
                .country(AddressData.CountryCode.PL)
                .price(12345L)
                .name("XXX")
                .build();
    }

    private PayMethod payMethodWithAllData() {
        return new PayMethod.Builder()
                .type(PayMethod.Type.PBL)
                .value(PayMethod.Code.blik)
                .authorizationCode(1)
                .build();
    }
}