package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductValidityTest {

    @Test
    public void shouldCreateProductWhenRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateProductWhenNotifyUrlIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().name(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateProductWhenUnitPriceIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().unitPrice(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateProductWhenQuantityIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().quantity(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreateProductWhenListingDateHasInvalidFormat() {
        // given/when/then
        assertThatThrownBy(builder().listingDate("2011-12-03")::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private Product.Builder builder() {
        return new Product.Builder()
                .name("RTV")
                .unitPrice(21000L)
                .quantity(1L);
    }
}