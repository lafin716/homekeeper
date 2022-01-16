package com.lafin.homekeeper.global.exception;

public class BuildingException extends HomeKeeperException {

    public BuildingException(String message) {
        super(message);
    }

    public static final BuildingException DUPLICATED_NAME = new BuildingException(ExceptionMessage.DUPLICATED_NAME);

}
