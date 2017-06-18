package com.techgarden.tasks.payu.client.request.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invoice extends AddressData {

    private String tin;
    private Boolean eInvoiceRequested;

    private Invoice(Builder builder) {
        super(builder);
        this.tin = builder.tin;
        this.eInvoiceRequested = builder.eInvoiceRequested;
    }

    public String getTin() {
        return tin;
    }

    public Boolean getEInvoiceRequested() {
        return eInvoiceRequested;
    }

    public static class Builder extends AddressData.Builder<Builder, Invoice> {

        private String tin;
        private Boolean eInvoiceRequested;

        public Builder tin(String tin) {
            this.tin = tin;
            return this;
        }

        public Builder eInvoiceRequested(Boolean eInvoiceRequested) {
            this.eInvoiceRequested = eInvoiceRequested;
            return this;
        }

        @Override
        protected Invoice newInstance() {
            return new Invoice(this);
        }
    }
}