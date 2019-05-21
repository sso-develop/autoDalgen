package com.lambert.db;

import com.lambert.db.model.Column;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lambert
 * @Date: 2019/3/25 21:56
 * @Description:
 */
public class ConnectionUtil {

    //声明Connection对象

    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://sql.v83.vhostgo.com:3306/linzekuan?useUnicode=true&amp;characterEncoding=UTF-8";
    //MySQL配置时的用户名
    String user = "linzekuan";
    //MySQL配置时的密码
    String password = "lzk1314";

    private Connection getCon() throws Exception{

        //加载驱动程序
        Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        Connection con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed()) System.out.println("Succeeded connecting to the Database!");
        return con;

    }

    public List<Column> getColumns(){

        List<Column> columnList = new ArrayList<Column>();

        try{

            Connection con = getCon();
            DatabaseMetaData dm = con.getMetaData();
            String tableName = "uums_sys_app";
            ResultSet colRet = dm.getColumns(null,"",tableName,"");


            while(colRet.next()) {
                Column column = new Column();
                column.setColumnName(colRet.getString("COLUMN_NAME"));
                column.setColumnType(colRet.getString("TYPE_NAME"));
                column.setDatasize(colRet.getInt("COLUMN_SIZE"));
                column.setDigits(colRet.getInt("DECIMAL_DIGITS"));
                column.setNullable(colRet.getInt("NULLABLE"));

                columnList.add(column);
            }


            return columnList;
        }catch (Exception e){
            e.printStackTrace();;
        }
        return null;
    }

}
