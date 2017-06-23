package com.techgarden.tasks.payu.gateway.response;

import com.techgarden.tasks.payu.gateway.response.entities.Status;
import com.techgarden.tasks.payu.gateway.response.entities.Status.Code;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderCreateResponseValidityTest {

    @Test
    public void shouldMarkResponseAsValidWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build().isValid()).isTrue();
    }

    @Test
    public void shouldMarkResponseAsInvalidInGivenScenarios() {
        // given/when/then
        assertThat(builder().redirectUri(null).build().isValid()).isFalse();
        assertThat(builder().orderId(null).build().isValid()).isFalse();
        assertThat(builder().status(null).build().isValid()).isFalse();
        assertThat(builder().status(new Status(Code.BUSINESS_ERROR)).build().isValid()).isFalse();
        assertThat(builder().httpCode(123).build().isValid()).isFalse();
    }

    private OrderCreateResponse.Builder builder() {
        return new OrderCreateResponse.Builder()
                .redirectUri("https://your.eshop.com/123456789")
                .orderId("123456789")
                .status(new Status(Code.SUCCESS))
                .extOrderId("123")
                .httpCode(200);
    }
}