package com.lambert.dalgen.mybatis.model.dbtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: PrimaryKeys.java, v 0.1 2019年05月21日 10:17 PM lambert Exp $
 */
public class PrimaryKeys {

    private List<Column> columnList;

    private String pkName;

    public void addColumn(Column column){
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

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }
}
