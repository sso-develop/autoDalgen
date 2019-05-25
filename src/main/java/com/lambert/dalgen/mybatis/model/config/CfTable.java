package com.lambert.dalgen.mybatis.model.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: CfTable.java, v 0.1 2019年05月25日 5:00 PM lambert Exp $
 */
public class CfTable {

    private String sqlname;
    private String sequence;
    private String physicalName;
    private String remark;

    private List<CfColumn>    columns;

    private List<CfOperation> operations;

    public void addColumn(CfColumn column) {
        if(columns == null) columns = new ArrayList<CfColumn>();
        this.columns.add(column);
    }


    public void addOperation(CfOperation operation) {
        if(operations == null) operations = new ArrayList<CfOperation>();
        this.operations.add(operation);
    }

    public String getSqlname() {
        return sqlname;
    }

    public void setSqlname(String sqlname) {
        this.sqlname = sqlname;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
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

    public List<CfOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<CfOperation> operations) {
        this.operations = operations;
    }

    public List<CfColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<CfColumn> columns) {
        this.columns = columns;
    }
}
