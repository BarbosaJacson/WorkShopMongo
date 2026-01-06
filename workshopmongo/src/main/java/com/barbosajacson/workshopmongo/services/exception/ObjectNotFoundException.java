package com.barbosajacson.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long seriaLVersionUID = 1L;

    public ObjectNotFoundException (String msg) {
    super(msg);
    }

}
