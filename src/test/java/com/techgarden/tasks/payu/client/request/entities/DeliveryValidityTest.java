package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DeliveryValidityTest {

    @Test
    public void shouldCreateDeliveryWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateDeliveryWhenStreetIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().street(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateDeliveryWhenPostalCodeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().postalCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateDeliveryWhenCityIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().city(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateDeliveryWhenCountryCodeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().countryCode(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateDeliveryWhenRecipientNameIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().recipientName(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private Delivery.Builder builder() {
        return new Delivery.Builder()
                .street("Nowakowskiego")
                .postalCode("87-123")
                .city("Gdańsk")
                .countryCode(AddressData.CountryCode.PL)
                .recipientName("Mateusz Maszkiewicz");
    }
}