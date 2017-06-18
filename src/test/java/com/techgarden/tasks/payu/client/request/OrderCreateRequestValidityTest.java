package com.techgarden.tasks.payu.client.request;

import com.techgarden.tasks.payu.client.request.entities.AddressData;
import com.techgarden.tasks.payu.client.request.entities.PayMethod;
import com.techgarden.tasks.payu.client.request.entities.Product;
import com.techgarden.tasks.payu.client.request.entities.ShippingMethod;
import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderCreateRequestValidityTest {

    @Test
    public void shouldCreateOrderCreateRequestWhenRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenNotifyUrlIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().notifyUrl(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenCustomerIpIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().customerIp(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenDescriptionIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().description(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenMerchantPosIdIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().merchantPosId(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenTotalAmountIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().totalAmount(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenCurrencyCodeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().currencyCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
   }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenProductListIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().products(emptyList())::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateOrderCreateRequestWhenBothPayMethodAndShippingMethodAreSet() {
        // given
        OrderCreateRequest.Builder builder = builder().shippingMethods(shippingMethod()).payMethod(payMethod());

        // when/then
        assertThatThrownBy(builder::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private OrderCreateRequest.Builder builder() {
        return new OrderCreateRequest.Builder()
                .notifyUrl("https://your.eshop.com/notify")
                .customerIp("127.0.0.1")
                .merchantPosId(300746L)
                .description("Zakup testowy")
                .currencyCode(OrderCreateRequest.CurrencyCode.PLN)
                .totalAmount(21000L)
                .products(product());
    }

    private ShippingMethod shippingMethod() {
        return new ShippingMethod.Builder()
                .country(AddressData.CountryCode.PL)
                .price(12345L)
                .name("XXX")
                .build();
    }

    private PayMethod payMethod() {
        return new PayMethod.Builder()
                .type(PayMethod.Type.PBL)
                .value(PayMethod.Code.blik)
                .authorizationCode(1)
                .build();
    }

    private Product product() {
        return new Product.Builder()
                .name("RTV")
                .unitPrice(21000L)
                .quantity(1L)
                .build();
    }
}