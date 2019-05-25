package com.lambert.dalgen.mybatis.model.java.domapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: DOMapperMethod.java, v 0.1 2019年05月25日 9:56 PM lambert Exp $
 */
public class DOMapperMethod {
    /**
     * 方法名
     */
    private String name;
    /**
     * 返回类型
     */
    private String returnClass;
    /**
     * 分页名称
     */
    private String pagingName;
    /**
     * sql
     */
    private String sql;
    /**
     * 是否分页
     */
    private String pagingFlag = "false";
    /**
     * 描述
     */
    private String desc;

    private List<DOMapperMethodParam> params;


    public void addParam(DOMapperMethodParam param) {
        if(this.params == null) this.params = new ArrayList<DOMapperMethodParam>();
        if(!this.params.contains(param)) {
            this.params.add(param);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnClass() {
        return returnClass;
    }

    public void setReturnClass(String returnClass) {
        this.returnClass = returnClass;
    }

    public String getPagingName() {
        return pagingName;
    }

    public void setPagingName(String pagingName) {
        this.pagingName = pagingName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getPagingFlag() {
        return pagingFlag;
    }

    public void setPagingFlag(String pagingFlag) {
        this.pagingFlag = pagingFlag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<DOMapperMethodParam> getParams() {
        return params;
    }

    public void setParams(List<DOMapperMethodParam> params) {
        this.params = params;
    }
}
