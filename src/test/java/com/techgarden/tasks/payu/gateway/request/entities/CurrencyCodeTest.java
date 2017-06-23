package com.techgarden.tasks.payu.gateway.request.entities;

import com.techgarden.tasks.payu.gateway.request.OrderCreateRequest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyCodeTest {

    @Test
    public void shouldScaleAmountInHUFCurrency() {
        // given/when
        Long amount = OrderCreateRequest.CurrencyCode.HUF.scaleAmount(12345L);

        //then
        assertThat(amount).isEqualTo(1234500L);
    }


    @Test
    public void shouldReturnNullAmountWhenAmountToScaleIsNull() {
        // given/when
        Long amount = OrderCreateRequest.CurrencyCode.EUR.scaleAmount(null);

        //then
        assertThat(amount).isNull();
    }
}