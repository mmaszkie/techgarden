package com.techgarden.tasks.payu.client.response.entities;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Status {

    private Code statusCode;

    public Status() {
    }

    public Status(Code code) {
        this.statusCode = code;
    }

    public Code getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Code statusCode) {
        this.statusCode = statusCode;
    }

    public enum Code {

        SUCCESS(200, 201, 302),
        WARNING_CONTINUE_REDIRECT(302),
        WARNING_CONTINUE_3DS(302),
        WARNING_CONTINUE_CVV(302),
        ERROR_SYNTAX(400),
        ERROR_VALUE_INVALID(400),
        ERROR_VALUE_MISSING(400),
        ERROR_ORDER_NOT_UNIQUE(400),
        UNAUTHORIZED(401),
        UNAUTHORIZED_REQUEST(403),
        DATA_NOT_FOUND(404),
        IMEOUT(408),
        BUSINESS_ERROR(500),
        ERROR_INTERNAL(500),
        GENERAL_ERROR(500),
        WARNING(500),
        SERVICE_NOT_AVAILABLE(503);

        private int[] validHttpCodes;

        Code(int... validHttpCodes) {
            this.validHttpCodes = validHttpCodes;
        }

        public List<Integer> getValidHttpCodes() {
            return stream(validHttpCodes).boxed().collect(toList());
        }
    }
}