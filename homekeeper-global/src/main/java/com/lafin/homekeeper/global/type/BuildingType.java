package com.lafin.homekeeper.global.type;

public enum BuildingType {

    APARTMENT("A"),
    VILLA("V"),
    UNKNOWN("");

    String code;

    BuildingType(String code) {
        this.code = code;
    }

    public static BuildingType of(String code) {
        for (BuildingType type : BuildingType.values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }

        return UNKNOWN;
    }

    public boolean isVilla() {
        return this == VILLA;
    }

    public boolean isApartment() {
        return this == APARTMENT;
    }

    public boolean isUnknown() {
        return this == UNKNOWN;
    }
}
