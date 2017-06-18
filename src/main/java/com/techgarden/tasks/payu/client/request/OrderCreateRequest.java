package com.techgarden.tasks.payu.client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techgarden.tasks.payu.client.request.entities.*;
import com.techgarden.tasks.payu.client.request.entities.actions.BuildAndValidate;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.ObjectUtils.allNotNull;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCreateRequest {

    private String notifyUrl;
    private String customerIp;
    private Long merchantPosId;
    private String description;
    private CurrencyCode currencyCode;
    private Long totalAmount;
    private List<Product> products;

    private String orderUrl;
    private String continueUrl;
    private String additionalDescription;
    private String extOrderId;
    private Settings settings;
    private Buyer buyer;
    private List<ShippingMethod> shippingMethods;
    private PayMethod payMethod;
    private Long validityTime;

    private OrderCreateRequest(Builder builder) {
        setRequiredParams(builder);
        setOptionalParams(builder);
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public Long getMerchantPosId() {
        return merchantPosId;
    }

    public String getDescription() {
        return description;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public String getContinueUrl() {
        return continueUrl;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public String getExtOrderId() {
        return extOrderId;
    }

    public Settings getSettings() {
        return settings;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public List<ShippingMethod> getShippingMethods() {
        return shippingMethods;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public Long getValidityTime() {
        return validityTime;
    }

    private void setRequiredParams(Builder builder) {
        this.notifyUrl = builder.notifyUrl;
        this.customerIp = builder.customerIp;
        this.merchantPosId = builder.merchantPosId;
        this.description = builder.description;
        this.currencyCode = builder.currencyCode;
        this.totalAmount = builder.totalAmount;
        this.products = builder.products;
    }

    private void setOptionalParams(Builder builder) {
        this.orderUrl = builder.orderUrl;
        this.continueUrl = builder.continueUrl;
        this.validityTime = builder.validityTime;
        this.additionalDescription = builder.additionalDescription;
        this.extOrderId = builder.extOrderId;
        this.settings = builder.settings;
        this.buyer = builder.buyer;
        this.shippingMethods = builder.shippingMethods;
        this.payMethod = builder.payMethod;
    }

    public enum CurrencyCode {

        PLN(1),
        EUR(1),
        HUF(100);

        private final int scaling;

        CurrencyCode(int scaling) {
            this.scaling = scaling;
        }

        public Long scaleAmount(Long amount) {
            if (amount == null) {
                return null;
            }
            return amount * scaling;
        }
    }

    public static class Builder extends BuildAndValidate<OrderCreateRequest> {

        private String notifyUrl;
        private String customerIp;
        private Long merchantPosId;
        private String description;
        private CurrencyCode currencyCode;
        private Long totalAmount;
        private List<Product> products;

        private String orderUrl;
        private String continueUrl;
        private String additionalDescription;
        private String extOrderId;
        private Settings settings;
        private Buyer buyer;
        private List<ShippingMethod> shippingMethods;
        private PayMethod payMethod;
        private Long validityTime;

        public Builder notifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public Builder customerIp(String customerIp) {
            this.customerIp = customerIp;
            return this;
        }

        public Builder merchantPosId(Long merchantPosId) {
            this.merchantPosId = merchantPosId;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder currencyCode(CurrencyCode currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder totalAmount(Long totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder products(List<Product> products) {
            this.products = products;
            return this;
        }

        public Builder products(Product... products) {
            this.products = stream(products).collect(toList());
            return this;
        }

        public Builder orderUrl(String orderUrl) {
            this.orderUrl = orderUrl;
            return this;
        }

        public Builder continueUrl(String continueUrl) {
            this.continueUrl = continueUrl;
            return this;
        }

        public Builder validityTime(Long validityTime) {
            this.validityTime = validityTime;
            return this;
        }

        public Builder additionalDescription(String additionalDescription) {
            this.additionalDescription = additionalDescription;
            return this;
        }

        public Builder extOrderId(String extOrderId) {
            this.extOrderId = extOrderId;
            return this;
        }

        public Builder settings(Settings settings) {
            this.settings = settings;
            return this;
        }

        public Builder buyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder shippingMethods(ShippingMethod... shippingMethods) {
            this.shippingMethods = stream(shippingMethods).collect(toList());
            return this;
        }

        public Builder payMethod(PayMethod payMethod) {
            this.payMethod = payMethod;
            return this;
        }

        @Override
        protected OrderCreateRequest newInstance() {
            return new OrderCreateRequest(this);
        }

        @Override
        public boolean isValid() {
            return isNoneBlank(notifyUrl, customerIp, description)
                    && allNotNull(merchantPosId, totalAmount, currencyCode)
                    && isNotEmpty(products)
                    && onlyOneIsSet(payMethod, shippingMethods);
        }

        private boolean onlyOneIsSet (PayMethod payMethod, List<ShippingMethod> shippingMethods) {
            return payMethod == null || CollectionUtils.isEmpty(shippingMethods);
        }
    }
}