package com.techgarden.tasks.payu.client.request.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techgarden.tasks.payu.client.request.entities.actions.BuildAndValidate;

import static org.apache.commons.lang3.ObjectUtils.allNotNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingMethod {

    private AddressData.CountryCode country;
    private Long price;
    private String name;

    private ShippingMethod(Builder builder) {
        setRequiredParams(builder);
    }

    private void setRequiredParams(Builder builder) {
        this.country = builder.countryCode;
        this.price = builder.price;
        this.name = builder.name;
    }

    public AddressData.CountryCode getCountry() {
        return country;
    }

    public Long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static class Builder extends BuildAndValidate<ShippingMethod> {

        private AddressData.CountryCode countryCode;
        private Long price;
        private String name;

        public Builder country(AddressData.CountryCode countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder price(Long price) {
            this.price = price;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        protected ShippingMethod newInstance() {
            return new ShippingMethod(this);
        }

        @Override
        public boolean isValid() {
            return isNotBlank(name) && allNotNull(countryCode, price);
        }
    }
}