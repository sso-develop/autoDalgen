package com.lambert.dalgen.mybatis.model.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: Base.java, v 0.1 2019年05月25日 9:04 PM lambert Exp $
 */
public class Base {
    /**
     * 类名
     */
    private String className;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 类路径
     */
    private String classPath;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 描述
     */
    private String desc;
    private List<String> importList;

    public void addImport(String importClass) {
        if(this.importList == null) importList = new ArrayList<String>();
        if (!this.importList.contains(importClass)) {
            this.importList.add(importClass);
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getImportList() {
        return importList;
    }

    public void setImportList(List<String> importList) {
        this.importList = importList;
    }
}
