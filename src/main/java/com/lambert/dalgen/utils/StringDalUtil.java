package com.lambert.dalgen.utils;

/**
 * @author lambert
 * @version $Id: StringDalUtil.java, v 0.1 2019年05月29日 8:38 PM lambert Exp $
 */
public class StringDalUtil {
    /**
     * Join string.
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @return the string
     */
    public static String join(String p1, String p2) {
        if (p1 == null && p2 == null) {
            return "";
        }
        String o1 = p1 == null ? "" : p1, o2 = p2 == null ? "" : p2;
        return o1 + " " + o2;
    }

    /**
     * Upper first string.
     *
     * @param str the str
     * @return the string
     */
    public static String upperFirst(String str) {
        return CamelCaseUtils.toCapitalizeCamelCase(CamelCaseUtils.toUnderlineName(str));

    }

    /**
     * Lower first string.
     *
     * @param str the str
     * @return the string
     */
    public static String lowerFirst(String str) {
        return CamelCaseUtils.toCamelCase(CamelCaseUtils.toUnderlineName(str));
    }
}
