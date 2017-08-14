package com.zxxz.lv.exception;

public class MailException extends Exception {
    private String message;

    public MailException(String message) {
        this.message = message;
    }

    public MailException() {

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
