package com.lafin.homekeeper.global.type;

public enum StuffUnit {

    EA("E", "개"),
    PERCENT("P", "%"),
    UNKNOWN("", "");

    String code;
    String unit;

    StuffUnit(String code, String unit) {
        this.code = code;
        this.unit = unit;
    }

    public static StuffUnit of(String code) {
        for (StuffUnit stuffUnit : StuffUnit.values()) {
            if (stuffUnit.code.equalsIgnoreCase(code)) {
                return stuffUnit;
            }
        }

        return UNKNOWN;
    }

}
