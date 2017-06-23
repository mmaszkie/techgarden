package com.techgarden.tasks.payu.gateway.request.entities;

import com.techgarden.tasks.payu.gateway.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EntitiesValidityTest {

    @Test
    public void shouldCreateEntitiesWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(billingBuilder().build()).isNotNull();
        assertThat(buyerBuilder().build()).isNotNull();
        assertThat(deliveryBuilder().build()).isNotNull();
        assertThat(invoiceBuilder().build()).isNotNull();
        assertThat(payMethodBuilder().build()).isNotNull();
        assertThat(productBuilder().build()).isNotNull();
        assertThat(shippingMethodBuilder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateBillingInGivenScenarios() {
        // given/when/then
        assertThatThrownBy(billingBuilder().street(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(billingBuilder().postalCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(billingBuilder().city(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(billingBuilder().countryCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(billingBuilder().recipientName(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateBuyerInGivenScenario() {
        // given/when/then
        assertThatThrownBy(buyerBuilder().email(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateDeliveryInGivenScenarios() {
        // given/when/then
        assertThatThrownBy(deliveryBuilder().street(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(deliveryBuilder().postalCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(deliveryBuilder().city(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(deliveryBuilder().countryCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(deliveryBuilder().recipientName(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateInvoiceInGivenScenarios() {
        // given/when/then
        assertThatThrownBy(invoiceBuilder().street(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(invoiceBuilder().postalCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(invoiceBuilder().city(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(invoiceBuilder().countryCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(invoiceBuilder().recipientName(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreatePayMethodInGivenScenarios() {
        // given/when/then
        assertThatThrownBy(payMethodBuilder().type(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(payMethodBuilder().value("")::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(payMethodBuilder().value("XXX")::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateProductInGivenScenarios() {
        // given/when/then
        assertThatThrownBy(productBuilder().name(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(productBuilder().unitPrice(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(productBuilder().quantity(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(productBuilder().listingDate("2011-12-03")::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateShippingMethodInGivenScenarios() {
        // given/when/then
        assertThatThrownBy(shippingMethodBuilder().country(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(shippingMethodBuilder().price(null)::build).isInstanceOf(Validate.InconsistentObject.class);
        assertThatThrownBy(shippingMethodBuilder().name(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private Billing.Builder billingBuilder() {
        return new Billing.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz");
    }

    private Buyer.Builder buyerBuilder() {
        return new Buyer.Builder().email("mmaszkie@gmail.com");
    }

    private Delivery.Builder deliveryBuilder() {
        return new Delivery.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz");
    }

    private Invoice.Builder invoiceBuilder() {
        return new Invoice.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz");
    }

    private PayMethod.Builder payMethodBuilder() {
        return new PayMethod.Builder()
                .type(PayMethod.Type.PBL)
                .value(PayMethod.Code.blik)
                .authorizationCode(1);
    }

    private Product.Builder productBuilder() {
        return new Product.Builder()
                .name("RTV")
                .unitPrice(21000L)
                .quantity(1L);
    }

    private ShippingMethod.Builder shippingMethodBuilder() {
        return new ShippingMethod.Builder()
                .country(AddressData.CountryCode.PL)
                .price(12345L)
                .name("XXX");
    }
}