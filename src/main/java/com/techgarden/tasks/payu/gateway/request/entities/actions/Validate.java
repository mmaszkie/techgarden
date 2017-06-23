package com.techgarden.tasks.payu.gateway.request.entities.actions;

public interface Validate {

    boolean isValid();

    class InconsistentObject extends RuntimeException {}

}
