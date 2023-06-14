package org.impl.list.exception;

public class ListIndexOutOfBounds extends Exception{

    private String message;

    public ListIndexOutOfBounds(String message) {
        super(message);
    }
    public String getMessage() {
        return message;
    }
}
