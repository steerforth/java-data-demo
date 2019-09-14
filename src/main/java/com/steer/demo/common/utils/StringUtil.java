package com.steer.demo.common.utils;

public class StringUtil {

    public static boolean isBlank(CharSequence cs){
        if (cs == null) {
            return true;
        } else {
            int length = cs.length();

            for (int i = 0; i < length; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

}
