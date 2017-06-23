package com.techgarden.tasks.payu.gateway.request.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techgarden.tasks.payu.gateway.request.entities.actions.BuildAndValidate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Buyer {

    private String email;

    private String customerId;
    private String extCustomerId;
    private String phone;
    private String firstName;
    private String lastName;
    private String nin;
    private Language language;
    private Delivery delivery;
    private Billing billing;
    private Invoice invoice;

    public String getEmail() {
        return email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getExtCustomerId() {
        return extCustomerId;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNin() {
        return nin;
    }

    public Language getLanguage() {
        return language;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Billing getBilling() {
        return billing;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    private Buyer(Builder builder) {
        setRequiredParams(builder);
        setOptionalParams(builder);
    }

    private void setRequiredParams(Builder builder) {
        this.email = builder.email;
    }

    private void setOptionalParams(Builder builder) {
        this.customerId = builder.customerId;
        this.extCustomerId = builder.extCustomerId;
        this.phone = builder.phone;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.nin = builder.nin;
        this.language = builder.language;
        this.delivery = builder.delivery;
        this.billing = builder.billing;
        this.invoice = builder.invoice;
    }
    
    public enum Language {

        pl,
        en,
        cs

    }

    public static class Builder extends BuildAndValidate<Buyer> {

        private String email;

        private String customerId;
        private String extCustomerId;
        private String phone;
        private String firstName;
        private String lastName;
        private String nin;
        private Language language;
        private Delivery delivery;
        private Billing billing;
        private Invoice invoice;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder extCustomerId(String extCustomerId) {
            this.extCustomerId = extCustomerId;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder firtName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder nin(String nin) {
            this.nin = nin;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder delivery(Delivery delivery) {
            this.delivery = delivery;
            return this;
        }

        public Builder billing(Billing billing) {
            this.billing = billing;
            return this;
        }

        public Builder invoice(Invoice invoice) {
            this.invoice = invoice;
            return this;
        }

        @Override
        protected Buyer newInstance() {
            return new Buyer(this);
        }

        @Override
        public boolean isValid() {
            return isNotBlank(email);
        }
    }
}