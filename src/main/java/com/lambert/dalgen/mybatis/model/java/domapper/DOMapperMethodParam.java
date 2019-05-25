package com.lambert.dalgen.mybatis.model.java.domapper;

/**
 * @author lambert
 * @version $Id: DOMapperMethodParam.java, v 0.1 2019年05月25日 9:59 PM lambert Exp $
 */
public class DOMapperMethodParam {
    /**
     * 参数类型
     */
    private String paramType;
    /**
     * 参数
     */
    private String param;

    public DOMapperMethodParam(String paramType, String param) {
        this.paramType = paramType;
        this.param = param;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
