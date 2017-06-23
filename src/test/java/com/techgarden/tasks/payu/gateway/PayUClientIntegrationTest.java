package com.techgarden.tasks.payu.gateway;

import com.techgarden.tasks.payu.gateway.request.OrderCreateRequest;
import com.techgarden.tasks.payu.gateway.request.entities.*;
import com.techgarden.tasks.payu.gateway.response.OrderCreateResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class PayUClientIntegrationTest {

    private static final String SANDBOX_AUTHORIZATION_TOKEN = "d9a4536e-62ba-4f60-8017-6053211d3f47";

    @Autowired
    private PayUClient client;

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