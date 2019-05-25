package com.lambert.dalgen.mybatis.model.config;

import com.lambert.dalgen.mybatis.enums.MultiplicityEnum;
import com.lambert.dalgen.mybatis.enums.ParamTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lambert
 * @version $Id: CfOperation.java, v 0.1 2019年05月25日 5:25 PM lambert Exp $
 */
public class CfOperation {
    /**
     * 操作名
     */
    private String name;
    private String paging;
    /**
     * 参数类型
     */
    private ParamTypeEnum paramType;
    /**
     * 返回类型
     */
    private MultiplicityEnum multiplicity;
    /**
     * 备注
     */
    private String remark;
    /**
     * 返回类型
     */
    private String resultType;
    /**
     *
     */
    private String resultMap;
    /**
     * sql
     */
    private String cdata;
    /**
     * sql
     */
    private String cdataPageCount;
    /**
     * 排序
     */
    private String sqlDesc;

    private Map<String, String> primitiveParams;

    private Map<String, String> primitiveForeachParams;



    public void addPrimitiveParam(String attr, String type) {
        if(this.primitiveParams == null) this.primitiveParams = new HashMap<String, String>();
        this.primitiveParams.put(attr, type);
    }
    public void addPrimitiveForeachParam(String itemName, String collName) {
        if(this.primitiveForeachParams == null) this.primitiveForeachParams = new HashMap<String, String>();
        if(this.primitiveForeachParams.containsKey(itemName)){
            this.primitiveForeachParams.put(itemName+collName, collName);
        }else {
            this.primitiveForeachParams.put(itemName, collName);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaging() {
        return paging;
    }

    public void setPaging(String paging) {
        this.paging = paging;
    }

    public ParamTypeEnum getParamType() {
        return paramType;
    }

    public void setParamType(ParamTypeEnum paramType) {
        this.paramType = paramType;
    }

    public MultiplicityEnum getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(MultiplicityEnum multiplicity) {
        this.multiplicity = multiplicity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultMap() {
        return resultMap;
    }

    public void setResultMap(String resultMap) {
        this.resultMap = resultMap;
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata;
    }

    public String getCdataPageCount() {
        return cdataPageCount;
    }

    public void setCdataPageCount(String cdataPageCount) {
        this.cdataPageCount = cdataPageCount;
    }

    public String getSqlDesc() {
        return sqlDesc;
    }

    public void setSqlDesc(String sqlDesc) {
        this.sqlDesc = sqlDesc;
    }

    public Map<String, String> getPrimitiveParams() {
        return primitiveParams;
    }

    public void setPrimitiveParams(Map<String, String> primitiveParams) {
        this.primitiveParams = primitiveParams;
    }

    public Map<String, String> getPrimitiveForeachParams() {
        return primitiveForeachParams;
    }

    public void setPrimitiveForeachParams(Map<String, String> primitiveForeachParams) {
        this.primitiveForeachParams = primitiveForeachParams;
    }
}
