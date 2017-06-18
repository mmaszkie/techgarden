package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShippingMethodValidityTest {

    @Test
    public void shouldCreateShippingMethodWhenRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateShippingMethodWhenCountryIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().country(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateShippingMethodWhenPriceIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().price(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateShippingMethodWhenNameIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().name(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private ShippingMethod.Builder builder() {
        return new ShippingMethod.Builder()
                .country(AddressData.CountryCode.PL)
                .price(12345L)
                .name("XXX");
    }
}