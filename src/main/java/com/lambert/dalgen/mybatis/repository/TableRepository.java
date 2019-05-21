package com.lambert.dalgen.mybatis.repository;

import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.mybatis.repository.db.MySQLTableRepository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: TableRepository.java, v 0.1 2019年05月21日 8:53 PM lambert Exp $
 */
public class TableRepository {

    public Table gainTable(Connection connection, String tableName) throws SQLException {
        MySQLTableRepository tableRepository = new MySQLTableRepository();
        return tableRepository.gainTable(connection,tableName);
    }

}
