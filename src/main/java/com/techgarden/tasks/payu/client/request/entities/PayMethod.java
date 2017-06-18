package com.techgarden.tasks.payu.client.request.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techgarden.tasks.payu.client.request.entities.actions.BuildAndValidate;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayMethod {

    private Type type;
    private String value;
    private Integer authorizationCode;
 
    private PayMethod(Builder builder) {
        setRequiredParams(builder);
        setOptionalParams(builder);
    }

    private void setRequiredParams(Builder builder) {
        this.type = builder.type;
        this.value = builder.value;
    }

    private void setOptionalParams(Builder builder) {
        this.authorizationCode = builder.authorizationCode;
    }

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Integer getAuthorizationCode() {
        return authorizationCode;
    }

    public static class Builder extends BuildAndValidate<PayMethod> {

        private Type type;
        private String value;
        private Integer authorizationCode;

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder value(Code code) {
            this.value = code.name();
            return this;
        }

        public Builder value(String token) {
            this.value = token;
            return this;
        }

        public Builder authorizationCode(Integer authorizationCode) {
            this.authorizationCode = authorizationCode;
            return this;
        }

        @Override
        protected PayMethod newInstance() {
            return new PayMethod(this);
        }

        @Override
        public boolean isValid() {
            return type != null && isNotBlank(value) && valueHasValidFormat();
        }

        private boolean valueHasValidFormat() {
            return Type.PBL == type && stream(Code.values()).anyMatch(x -> x.name().equals(value));
        }
    }

    public enum Type {

        PBL,
        CARD_TOKEN,
        BANK_TOKEN

    }

    public enum Code {

        c,
        ma,
        vc,
        blik,
        m,
        mtex,
        w,
        o,
        i,
        p,
        pkex,
        g,
        gbx,
        gbex,
        nlx,
        nlex,
        ib,
        l,
        as,
        exas,
        u,
        ab,
        exab,
        ps,
        wm,
        wd,
        wr,
        wc,
        bo,
        bnx,
        bnex,
        orx,
        orex,
        b,
        pu,
        ai,
        t,
        cs,
        mp,
        kb,
        rf,
        pg,
        pv,
        pf,
        era,
        cb,
        uc,
        bt,
        pt

    }
}