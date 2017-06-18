package com.techgarden.tasks.payu.client.request.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Delivery extends AddressData {

    private Delivery(Builder builder) {
        super(builder);
    }

    public static class Builder extends AddressData.Builder<Builder, Delivery> {

        @Override
        protected Delivery newInstance() {
            return new Delivery(this);
        }
    }
}