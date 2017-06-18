package com.techgarden.tasks.payu.client.request.entities;

import com.techgarden.tasks.payu.client.request.OrderCreateRequest;
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
    public void shouldReturnNullWhenAmountToScaleIsNull() {
        // given/when
        Long amount = OrderCreateRequest.CurrencyCode.HUF.scaleAmount(null);

        //then
        assertThat(amount).isNull();
    }
}