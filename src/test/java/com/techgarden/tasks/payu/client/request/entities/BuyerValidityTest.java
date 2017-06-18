package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerValidityTest {

    @Test
    public void shouldCreateBuyerWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreateBuyerWhenEmailIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().email(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private Buyer.Builder builder() {
        return new Buyer.Builder().email("mmaszkie@gmail.com");
    }
}