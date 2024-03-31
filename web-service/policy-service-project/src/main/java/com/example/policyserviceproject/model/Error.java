package com.example.policyserviceproject.model;

public enum Error {
    EMPTY_INSURE("INS400", "Insure name cannot be empty"),
    NOT_FOUND_INSURE("INS404", "Insured name cannot be found."),
    BAD_MESSAGE("MSG400", "Message Id cannot be empty"),
    BAD_DATE("DAT400", "Sent Date Time cannot be empty");

    private final String code;
    private final String message;

    private Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
