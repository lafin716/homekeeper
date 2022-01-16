package com.lafin.homekeeper.global.exception;

public class UserException extends HomeKeeperException {

    public static final UserException DUPLICATED_EMAIL = new UserException(ExceptionMessage.DUPLICATED_EMAIL);
    public static final UserException NOT_FOUND_USER = new UserException(ExceptionMessage.NOT_FOUND_USER);

    public UserException(String message) {
        super(message);
    }
}
