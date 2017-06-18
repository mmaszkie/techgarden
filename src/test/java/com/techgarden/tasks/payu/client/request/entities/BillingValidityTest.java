package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BillingValidityTest {

    @Test
    public void shouldCreateBillingWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateBillingWhenStreetIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().street(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateBillingWhenPostalCodeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().postalCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateBillingWhenCityIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().city(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateBillingWhenCountryCodeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().countryCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateBillingWhenRecipientNameIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().recipientName(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private Billing.Builder builder() {
        return new Billing.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz");
    }
}