package com.lafin.homekeeper.global.exception;

public class BuildingException extends HomeKeeperException {

    public BuildingException(String message) {
        super(message);
    }

    public static final BuildingException DUPLICATED_NAME = new BuildingException(ExceptionMessage.DUPLICATED_NAME);
    public static final BuildingException NOT_FOUND_BUILDING = new BuildingException(ExceptionMessage.NOT_FOUND_BUILDING);
    public static final BuildingException NOT_OWNER = new BuildingException(ExceptionMessage.NOT_OWNER);

}
