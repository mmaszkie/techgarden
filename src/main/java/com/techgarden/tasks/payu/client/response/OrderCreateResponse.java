package com.techgarden.tasks.payu.client.response;

import com.techgarden.tasks.payu.client.request.entities.actions.Build;
import com.techgarden.tasks.payu.client.response.entities.Status;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class OrderCreateResponse {

    private String redirectUri;
    private String orderId;
    private Integer httpCode;
    private Status status;
    private String extOrderId;

    public OrderCreateResponse() {}

    private OrderCreateResponse(Builder builder) {
        setRequiredParams(builder);
        setOptionalParams(builder);
    }

    private void setRequiredParams(Builder builder) {
        this.redirectUri = builder.redirectUri;
        this.orderId = builder.orderId;
        this.httpCode = builder.httpCode;
        this.status = builder.status;
    }

    private void setOptionalParams(Builder builder) {
        this.extOrderId = builder.extOrderId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExtOrderId() {
        return extOrderId;
    }

    public void setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public static class Builder extends Build<OrderCreateResponse> {

        private String redirectUri;
        private String orderId;
        private Integer httpCode;
        private Status status;
        private String extOrderId;

        public Builder redirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder httpCode(Integer httpCode) {
            this.httpCode = httpCode;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder extOrderId(String extOrderId) {
            this.extOrderId = extOrderId;
            return this;
        }

        @Override
        public OrderCreateResponse build() {
            return new OrderCreateResponse(this);
        }
    }

    public boolean isValid() {
        return isSuccess() && isNotBlank(redirectUri) && isNotBlank(orderId);
    }

    private boolean isSuccess() {
        if (status == null) {
            return false;
        }
        Status.Code statusCode = status.getStatusCode();
        return statusCode == Status.Code.SUCCESS && statusCode.getValidHttpCodes().contains(httpCode);
    }
}