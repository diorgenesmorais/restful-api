package com.dms.restful.core.domain.utils;

public class HandleData {
    private HandleData() {
    }

    public static String handlerValue(String value) {
        if (value == null) return "";
        return value.trim().replace(",", ".");
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        return handlerValue(str).matches("-?\\d+(\\.\\d+)?");
    }
}
