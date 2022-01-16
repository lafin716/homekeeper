package com.lafin.homekeeper.global.exception;

public class HomeKeeperException extends RuntimeException {

    public HomeKeeperException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
