package com.lafin.homekeeper.global.exception;

public class UserException extends HomeKeeperException {

    public static final UserException DUPLICATED_EMAIL = new UserException(ExceptionMessage.DUPLICATED_EMAIL);

    public UserException(String message) {
        super(message);
    }
}
