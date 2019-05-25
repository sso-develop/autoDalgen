package com.lambert.dalgen.mybatis.model.java;

/**
 * @author lambert
 * @version $Id: Filelds.java, v 0.1 2019年05月25日 9:06 PM lambert Exp $
 */
public class Filelds {

    private String javaType;
    private String name;
    /**
     * 描述
     */
    private String desc;

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
