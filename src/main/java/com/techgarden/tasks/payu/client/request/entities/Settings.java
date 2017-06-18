package com.techgarden.tasks.payu.client.request.entities;

public class Settings {

    private final boolean invoiceDisabled;

    public Settings(boolean invoiceDisabled) {
        this.invoiceDisabled = invoiceDisabled;
    }

    public boolean isInvoiceDisabled() {
        return invoiceDisabled;
    }
}