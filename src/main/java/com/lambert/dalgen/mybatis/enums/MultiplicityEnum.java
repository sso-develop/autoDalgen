package com.lambert.dalgen.mybatis.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 返回类型
 * @author lambert
 * @version $Id: MultiplicityEnum.java, v 0.1 2019年05月29日 8:29 PM lambert Exp $
 */
public enum MultiplicityEnum {
    /**
     * 对象
     */
    one("one"),
    /**
     * 集合
     */
    many("many"),
    /**
     * 分页对象
     */
    paging("paging");

    /**
     * The Code.
     */
    private String code;

    /**
     * Instantiates a new Multiplicity enum.
     *
     * @param code the code
     */
    private MultiplicityEnum(String code) {
        this.code = code;
    }

    /**
     * Gets by code.
     *
     * @param code the code
     * @return the by code
     */
    public static MultiplicityEnum getByCode(String code) {
        for (MultiplicityEnum multiplicityEnum : MultiplicityEnum.values()) {
            if (StringUtils.equals(code, multiplicityEnum.code)) {
                return multiplicityEnum;
            }
        }
        return MultiplicityEnum.one;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }
}
