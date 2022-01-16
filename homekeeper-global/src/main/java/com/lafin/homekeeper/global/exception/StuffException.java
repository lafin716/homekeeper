package com.lafin.homekeeper.global.exception;

public class StuffException extends HomeKeeperException {

    public static final StuffException NOT_FOUND_STUFF = new StuffException(ExceptionMessage.NOT_FOUND_STUFF);

    public StuffException(String message) {
        super(message);
    }
}
