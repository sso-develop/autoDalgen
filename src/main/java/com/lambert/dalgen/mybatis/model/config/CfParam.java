package com.lambert.dalgen.mybatis.model.config;

/**
 * @author lambert
 * @version $Id: CfParam.java, v 0.1 2019年08月10日 11:08 AM lambert Exp $
 */
public class CfParam {
    /** 参数名称 */
    private String name;
    /** java类型 */
    private String javaType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
}
