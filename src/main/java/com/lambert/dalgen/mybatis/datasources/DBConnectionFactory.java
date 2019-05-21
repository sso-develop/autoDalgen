package com.lambert.dalgen.mybatis.datasources;

import com.lambert.dalgen.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author lambert
 * @version $Id: DBConnectionFactory.java, v 0.1 2019年05月21日 8:19 PM lambert Exp $
 */
public class DBConnectionFactory {

    private static final Logger logger = LoggerFactory.getLogger(DBConnectionFactory.class);

    //声明Connection对象

    //驱动程序名
    static String  driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    static String url = "jdbc:mysql://sql.v83.vhostgo.com:3306/linzekuan?useUnicode=true&amp;characterEncoding=UTF-8";
    //MySQL配置时的用户名
    static String user = "linzekuan";
    //MySQL配置时的密码
    static String password = "lzk1314";

    public static Connection  getConnection() {
        LoggerUtil.info(logger,"==== init connection ====");
        Connection connection = null;
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            connection = DriverManager.getConnection(url,user,password);
            LoggerUtil.info(logger,"==== init connection success ====");
        }catch (Exception e){
            e.printStackTrace();
            LoggerUtil.info(logger,"==== init connection error ====");
        }
        return  connection;
    }
}
