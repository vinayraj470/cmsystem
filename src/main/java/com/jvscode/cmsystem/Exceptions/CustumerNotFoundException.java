package com.jvscode.cmsystem.Exceptions;

public class CustumerNotFoundException extends RuntimeException {

    public CustumerNotFoundException() {
        super();
    }

    public CustumerNotFoundException(String message) {
        super(message);
    }
}
