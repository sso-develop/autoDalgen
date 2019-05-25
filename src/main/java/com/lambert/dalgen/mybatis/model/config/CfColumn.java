package com.lambert.dalgen.mybatis.model.config;

/**
 * @author lambert
 * @version $Id: CfColumn.java, v 0.1 2019年05月25日 7:25 PM lambert Exp $
 */
public class CfColumn {

    private String name;
    private String javaType;
    private String sqlType;
    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }
}
