package com.techgarden.tasks.payu.gateway.request;

import com.techgarden.tasks.payu.gateway.request.OrderCreateRequest;
import com.techgarden.tasks.payu.gateway.request.entities.AddressData;
import com.techgarden.tasks.payu.gateway.request.entities.PayMethod;
import com.techgarden.tasks.payu.gateway.request.entities.Product;
import com.techgarden.tasks.payu.gateway.request.entities.ShippingMethod;
import com.techgarden.tasks.payu.gateway.request.entities.actions.Validate;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderCreateRequestValidityTest {

    @Test
    public void shouldCreateOrderCreateRequestWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(orderBuilder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateOrderCreateRequestInGivenScenarios() {
        // given/when/then
        assertThatThrownBy(orderBuilder().notifyUrl(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(orderBuilder().customerIp(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(orderBuilder().merchantPosId(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(orderBuilder().totalAmount(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(orderBuilder().currencyCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(orderBuilder().products(emptyList())::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(orderBuilder().shippingMethods(shippingMethod()).payMethod(payMethod())::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private OrderCreateRequest.Builder orderBuilder() {
        return new OrderCreateRequest.Builder()
                .notifyUrl("https://your.eshop.com/notify")
                .customerIp("127.0.0.1")
                .merchantPosId(300746L)
                .description("Zakup testowy")
                .currencyCode(OrderCreateRequest.CurrencyCode.PLN)
                .totalAmount(21000L)
                .products(product());
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

    private ShippingMethod shippingMethod() {
        return new ShippingMethod.Builder()
                .country(AddressData.CountryCode.PL)
                .price(12345L)
                .name("XXX")
                .build();
    }
}