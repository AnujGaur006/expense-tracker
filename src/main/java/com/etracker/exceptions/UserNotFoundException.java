package com.etracker.exceptions;

import com.etracker.model.Expense;

public class UserNotFoundException extends Exception{

    private String message;

    public UserNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
