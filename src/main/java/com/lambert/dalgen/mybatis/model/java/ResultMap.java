package com.lambert.dalgen.mybatis.model.java;

import com.lambert.dalgen.mybatis.model.config.CfColumn;

import java.util.List;

/**
 * @author lambert
 * @version $Id: ResultMap.java, v 0.1 2019年05月25日 10:26 PM lambert Exp $
 */
public class ResultMap extends DO {

    private String name;
    private String type;
    private List<CfColumn> columnList;

    public void addColumn(CfColumn column) {
        this.columnList.add(column);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CfColumn> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<CfColumn> columnList) {
        this.columnList = columnList;
    }
}
