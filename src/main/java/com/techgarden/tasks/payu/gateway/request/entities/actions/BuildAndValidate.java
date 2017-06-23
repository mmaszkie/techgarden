package com.techgarden.tasks.payu.gateway.request.entities.actions;

public abstract class BuildAndValidate<T> extends Build<T> implements Validate {

    @Override
    public T build() {
        if (!isValid()) {
            throw new InconsistentObject();
        }
        return newInstance();
    }

    protected abstract T newInstance();
}

