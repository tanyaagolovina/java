package com.epam.task61.util.exception;

public class SQLClosingConnectionError extends Exception {
    public SQLClosingConnectionError(String message){
        super(message);
    }
}
