package com.lambert.dalgen.mybatis.model.java;

import com.lambert.dalgen.mybatis.model.config.CfTable;

/**
 * @author lambert
 * @version $Id: XmlMapper.java, v 0.1 2019年05月25日 5:46 PM lambert Exp $
 */
public class XmlMapper {

    private CfTable cfTable;

    private DO doClass;

    private Model modelClass;

    private DOMapper doMapper;

    public CfTable getCfTable() {
        return cfTable;
    }

    public void setCfTable(CfTable cfTable) {
        this.cfTable = cfTable;
    }

    public DO getDoClass() {
        return doClass;
    }

    public void setDoClass(DO doClass) {
        this.doClass = doClass;
    }

    public Model getModelClass() {
        return modelClass;
    }

    public void setModelClass(Model modelClass) {
        this.modelClass = modelClass;
    }

    public DOMapper getDoMapper() {
        return doMapper;
    }

    public void setDoMapper(DOMapper doMapper) {
        this.doMapper = doMapper;
    }
}
