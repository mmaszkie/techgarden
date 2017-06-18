package com.techgarden.tasks.payu.client.request.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Billing extends AddressData {

    private Billing(Builder builder) {
        super(builder);
    }

    public static class Builder extends AddressData.Builder<Builder, Billing> {

        @Override
        protected Billing newInstance() {
            return new Billing(this);
        }
    }
}