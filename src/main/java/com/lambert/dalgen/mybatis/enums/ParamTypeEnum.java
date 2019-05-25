package com.lambert.dalgen.mybatis.enums;

import org.apache.commons.lang.StringUtils;

/**
 *
 * 参数类型
 */
public enum ParamTypeEnum {
    /**
     * DO作为参数.
     */
    object("object"),
    /**
     * 原生态参数.
     */
    primitive("primitive");

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
