package com.techgarden.tasks.payu.client.response;

import com.techgarden.tasks.payu.client.response.entities.Status;
import com.techgarden.tasks.payu.client.response.entities.Status.Code;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderCreateResponseTest {

    @Test
    public void shouldTreatResponseAsValidWhenAllRequiredDataAreSet() {
        // given/when/then
        assertThat(builder().build().isValid()).isTrue();
    }

    @Test
    public void shouldTreatResponseAsInvalidWhenRedirectUriIsNotSet() {
        // given/when/then
        assertThat(builder().redirectUri(null).build().isValid()).isFalse();
    }

    @Test
    public void shouldTreatResponseAsInvalidWhenOrderIdIsNotSet() {
        // given/when/then
        assertThat(builder().orderId(null).build().isValid()).isFalse();
    }

    @Test
    public void shouldTreatResponseAsInvalidWhenStatusIsNotSet() {
        // given/when/then
        assertThat(builder().status(null).build().isValid()).isFalse();
    }

    @Test
    public void shouldTreatResponseAsInvalidWhenStatusIsNotSuccess() {
        // given/when/then
        assertThat(builder().status(new Status(Code.BUSINESS_ERROR)).build().isValid()).isFalse();
    }

    @Test
    public void shouldTreatResponseAsInvalidWhenStatusIsSuccessButHttpCodeIsNotLegitimate() {
        // given/when/then
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