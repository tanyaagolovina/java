package com.epam.task61.util.exception;

public class SQLConnectionError extends Exception{
    public SQLConnectionError(String message){
        super(message);
    }
}
