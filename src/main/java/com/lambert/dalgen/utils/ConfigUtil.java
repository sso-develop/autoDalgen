package com.lambert.dalgen.utils;

import com.lambert.dalgen.mybatis.model.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lambert
 * @version $Id: ConfigUtil.java, v 0.1 2019年05月23日 12:04 AM lambert Exp $
 */
public class ConfigUtil {

    private static Config config;


    static {
//    <typemap from="java.sql.Date" to="java.util.Date"/>
//    <typemap from="java.sql.Time" to="java.util.Date"/>
//    <typemap from="java.sql.Timestamp" to="java.util.Date"/>
//    <typemap from="java.math.BigDecimal" to="Long"/>
//    <typemap from="byte" to="int"/>
//    <typemap from="short" to="int"/>
        Map<String, String> typeMap = new HashMap<String, String>();

        typeMap.put("java.sql.Date","java.util.Date");
        typeMap.put("java.sql.Time","java.util.Date");
        typeMap.put("java.sql.Timestamp","java.util.Date");
        typeMap.put("java.math.BigDecimal","Long");
        typeMap.put("byte","int");
        typeMap.put("short","int");
        if(config == null){
            config = new Config();
        }
        config.setTypeMap(typeMap);

    }

    public static Config getConfig() {

        return config;
    }

}
