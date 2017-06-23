package com.techgarden.tasks.payu.gateway.request.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techgarden.tasks.payu.gateway.request.entities.actions.BuildAndValidate;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import static org.apache.commons.lang3.ObjectUtils.allNotNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    private String name;
    private Long unitPrice;
    private Long quantity;

    private Boolean virtual;
    private String listingDate;

    private Product(Builder builder) {
        setRequiredParams(builder);
        setOptionalParams(builder);
    }

    public String getName() {
        return name;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Boolean getVirtual() {
        return virtual;
    }

    public String getListingDate() {
        return listingDate;
    }

    private void setRequiredParams(Builder builder) {
        this.name = builder.name;
        this.unitPrice = builder.unitPrice;
        this.quantity = builder.quantity;
    }

    private void setOptionalParams(Builder builder) {
        this.virtual = builder.virtual;
        this.listingDate = builder.listingDate;
    }

    public static class Builder extends BuildAndValidate<Product> {

        private String name;
        private Long unitPrice;
        private Long quantity;

        private Boolean virtual;
        private String listingDate;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder unitPrice(Long unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder virtual(Boolean virtual) {
            this.virtual = virtual;
            return this;
        }

        public Builder listingDate(ZonedDateTime listingDate) {
            this.listingDate = ISO_OFFSET_DATE_TIME.format(listingDate);
            return this;
        }

        public Builder listingDate(String listingDate) {
            this.listingDate = listingDate;
            return this;
        }

        @Override
        protected Product newInstance() {
            return new Product(this);
        }

        @Override
        public boolean isValid() {
            return isNotBlank(name) && allNotNull(unitPrice, quantity) && listingDateHasValidFormat();
        }

        private boolean listingDateHasValidFormat() {
            try {
                if (listingDate != null) {
                    LocalDateTime.parse(listingDate, ISO_OFFSET_DATE_TIME);
                }
            } catch (DateTimeParseException e) {
                return false;
            }
            return true;
        }
    }
}