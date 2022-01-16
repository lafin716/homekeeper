package com.lafin.homekeeper.global.exception;

public class HomeKeeperException extends RuntimeException {

    public static final HomeKeeperException NOT_ALLOWED_UPDATE = new HomeKeeperException(ExceptionMessage.NOT_ALLOWED_UPDATE);

    public HomeKeeperException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
