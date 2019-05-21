package com.lambert.vm.model;

import java.util.List;

/**
 * @Auther: lambert
 * @Date: 2019/3/26 21:44
 * @Description:
 */
public class TableTemplate {

    private String namespace;

    private String table;

    private String className;

    private String DAOClassName;

    private String DOClassName;

    private String DOPackage;

    private List<String> doImports;

    private List<Operation> operations;
}
