package com.uncmath25.template.webapi.entities;

public class SimpleResponse {
    private String message;

    public SimpleResponse() {}
    public SimpleResponse(final String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
