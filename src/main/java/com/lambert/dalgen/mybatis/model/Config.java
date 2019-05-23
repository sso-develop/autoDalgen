package com.lambert.dalgen.mybatis.model;

import java.util.Map;

/**
 * @author lambert
 * @version $Id: Config.java, v 0.1 2019年05月23日 12:04 AM lambert Exp $
 */
public class Config {


    private Map<String, String> typeMap;//sql 类型与JAVA类型隐射

    public Map<String, String> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, String> typeMap) {
        this.typeMap = typeMap;
    }
}
