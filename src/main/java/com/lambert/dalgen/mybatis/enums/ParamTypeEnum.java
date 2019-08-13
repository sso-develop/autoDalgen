package com.lambert.dalgen.mybatis.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 参数类型
 * @author lambert
 * @version $Id: A.java, v 0.1 2019年05月29日 8:31 PM lambert Exp $
 */
public enum ParamTypeEnum {
    /** DO作为参数 */
    object("object"),
    /** 原生态参数 */
    primitive("primitive"),
    /** 扩展参数 */
    extra("extra");


    /**
     * The Code.
     */
    private String code;

    /**
     * Instantiates a new Param type enum.
     *
     * @param code the code
     */
    private ParamTypeEnum(String code) {
        this.code = code;
    }

    /**
     * Get by code param type enum.
     *
     * @param code the code
     * @return the param type enum
     */
    public static ParamTypeEnum getByCode(String code) {

        for (ParamTypeEnum paramTypeEnum : ParamTypeEnum.values()) {
            if (StringUtils.equals(code, paramTypeEnum.code)) {
                return paramTypeEnum;
            }
        }
        return ParamTypeEnum.primitive;
    }

}
