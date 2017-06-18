package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InvoiceValidityTest {

    @Test
    public void shouldCreateInvoiceWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateInvoiceWhenStreetIsNotSet() {
        // given/when
        assertThatThrownBy(builder().street(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateInvoiceWhenPostalCodeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().postalCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateInvoiceWhenCityIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().city(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateInvoiceWhenCountryCodeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().countryCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateInvoiceWhenRecipientNameIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().recipientName(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private Invoice.Builder builder() {
        return new Invoice.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz");
    }
}