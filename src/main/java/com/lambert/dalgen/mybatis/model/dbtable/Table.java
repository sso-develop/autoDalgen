package com.lambert.dalgen.mybatis.model.dbtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: Table.java, v 0.1 2019年05月21日 9:51 PM lambert Exp $
 */
public class Table {

    private List<Column> columnList;

    private PrimaryKeys primaryKeys;
    private String sqlName;
    private String javaName;
    private String physicalName;
    private String remark;

    public void addColumn(Column column) {
        if(this.columnList == null){
            this.columnList = new ArrayList<Column>();
        }
        this.columnList.add(column);
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public PrimaryKeys getPrimaryKeys() {
        return primaryKeys;
    }

    public void setPrimaryKeys(PrimaryKeys primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    public String getPhysicalName() {
        return physicalName;
    }

    public void setPhysicalName(String physicalName) {
        this.physicalName = physicalName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSqlName() {
        return sqlName;
    }

    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }
}
