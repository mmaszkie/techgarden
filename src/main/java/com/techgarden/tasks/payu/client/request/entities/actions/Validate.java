package com.techgarden.tasks.payu.client.request.entities.actions;

public interface Validate {

    boolean isValid();

    class InconsistentObject extends RuntimeException {}

}
