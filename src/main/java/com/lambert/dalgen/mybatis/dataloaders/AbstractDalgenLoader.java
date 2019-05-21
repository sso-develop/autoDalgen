package com.lambert.dalgen.mybatis.dataloaders;

import com.lambert.dalgen.mybatis.datasources.DBConnectionFactory;
import com.lambert.dalgen.mybatis.model.dbtable.Table;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: AbstractDalgenLoader.java, v 0.1 2019年05月21日 9:03 PM lambert Exp $
 */
public abstract class AbstractDalgenLoader {

    public Table load(){

        Connection connection = null;
        try {
            connection = DBConnectionFactory.getConnection();
            return load(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public abstract Table load(Connection connection) throws Exception;
}
