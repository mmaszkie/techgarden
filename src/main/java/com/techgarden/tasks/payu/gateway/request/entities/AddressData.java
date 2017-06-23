package com.techgarden.tasks.payu.gateway.request.entities;

import com.techgarden.tasks.payu.gateway.request.entities.actions.BuildAndValidate;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

public abstract class AddressData<B extends AddressData.Builder, E extends AddressData> {

    private String street;
    private String postalCode;
    private String city;
    private CountryCode countryCode;
    private String recipientName;

    private String postalBox;
    private String state;
    private String name;
    private String recipientPhone;
    private String recipientEmail;

    protected AddressData(Builder<B, E> builder) {
        setRequiredParams(builder);
        setOptionalParams(builder);
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getPostalBox() {
        return postalBox;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    private void setRequiredParams(Builder builder) {
        this.street = builder.street;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
        this.countryCode = builder.countryCode;
        this.recipientName = builder.recipientName;
    }

    private void setOptionalParams(Builder builder) {
        this.postalBox = builder.postalBox;
        this.state = builder.state;
        this.name = builder.name;
        this.recipientPhone = builder.recipientPhone;
        this.recipientEmail = builder.recipientEmail;
    }

    public enum CountryCode {

        PL,
        GB,
        CZ

    }

    public abstract static class Builder<B extends Builder, E extends AddressData> extends BuildAndValidate<E> {

        private String street;
        private String postalCode;
        private String city;
        private CountryCode countryCode;
        private String recipientName;

        private String postalBox;
        private String state;
        private String name;
        private String recipientPhone;
        private String recipientEmail;

        public B street(String street) {
            this.street = street;
            return (B) (this);
        }

        public B postalCode(String postalCode) {
            this.postalCode = postalCode;
            return (B) (this);
        }

        public B city(String city) {
            this.city = city;
            return (B) (this);
        }

        public B countryCode(CountryCode countryCode) {
            this.countryCode = countryCode;
            return (B) (this);
        }

        public B recipientName(String recipientName) {
            this.recipientName = recipientName;
            return (B) (this);
        }

        public B postalBox(String postalBox) {
            this.postalBox = postalBox;
            return (B) (this);
        }

        public B state(String state) {
            this.state = state;
            return (B) (this);
        }

        public B name(String name) {
            this.name = name;
            return (B) (this);
        }

        public B recipientPhone(String recipientPhone) {
            this.recipientPhone = recipientPhone;
            return (B) (this);
        }

        public B recipientEmail(String recipientEmail) {
            this.recipientEmail = recipientEmail;
            return (B) (this);
        }

        @Override
        public boolean isValid() {
            return isNoneBlank(street, postalCode, city, recipientName) && countryCode != null;
        }
    }
}