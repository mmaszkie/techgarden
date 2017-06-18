package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.entities.actions.Validate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PayMethodValidityTest {

    @Test
    public void shouldCreatePayMethodWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build()).isNotNull();
    }

    @Test
    public void shouldNotCreatePayMethodWhenTypeIsNotSet() {
        // given/when/then
        assertThatThrownBy(builder().type(null)::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreatePayMethodWhenValueIsEmpty() {
        // given/when/then
        assertThatThrownBy(builder().value("")::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    @Test
    public void shouldNotCreatePayMethodWhenTypeIsPBLAndValueIsNotRecognized() {
        // given/when/then
        assertThatThrownBy(builder().value("XXX")::build).isInstanceOf(Validate.InconsistentObject.class);
    }

    private PayMethod.Builder builder() {
        return new PayMethod.Builder()
                .type(PayMethod.Type.PBL)
                .value(PayMethod.Code.blik)
                .authorizationCode(1);
    }
}