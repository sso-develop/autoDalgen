package com.lambert.dalgen.mybatis.repository.db;

import com.lambert.dalgen.mybatis.enums.TypeMapEnum;
import com.lambert.dalgen.mybatis.model.dbtable.Column;
import com.lambert.dalgen.mybatis.model.dbtable.PrimaryKeys;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.utils.CamelCaseUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.JdbcType;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: MySQLTableRepository.java, v 0.1 2019年05月21日 8:55 PM lambert Exp $
 */
public class MySQLTableRepository {

    public Table gainTable(Connection connection,String tableName) throws SQLException {


        String logicName = tableName;
        String physicalName = tableName;

        DatabaseMetaData databaseMetaData = connection.getMetaData();

        //生成table
        Table table = new Table();
        fillColumns(connection,databaseMetaData,tableName,table);
        fillPrimaryKeys(connection,databaseMetaData,tableName,table);

        table.setPhysicalName(physicalName);
        table.setSqlName(logicName);
        table.setJavaName(physicalName);
        table.setRemark(logicName);

        return table;
    }

    private void fillColumns(Connection connection, DatabaseMetaData databaseMetaData,String tableName,Table table) throws SQLException {
        //指定表字段
        ResultSet resultSet = databaseMetaData.getColumns(connection.getCatalog(), null, tableName,
                null);

        //组装字段
        while (resultSet.next()) {
            Column column = new Column();
            column.setSqlName(Str(resultSet, "COLUMN_NAME"));
            column.setSqlType(JdbcType.forCode(resultSet.getInt("DATA_TYPE")).name());
            column.setDefaultValue(Str(resultSet, "COLUMN_DEF"));
            column.setJavaName(CamelCaseUtils.toCamelCase(column.getSqlName()));
            column.setJavaType(getJavaType());
            column.setRemarks(Str(resultSet, "REMARKS", column.getSqlName()));
            table.addColumn(column);
        }
    }

    private void fillPrimaryKeys(Connection connection, DatabaseMetaData databaseMetaData,String tableName,Table table) throws SQLException {
        PrimaryKeys primaryKeys = null;

        ResultSet resultSet = databaseMetaData.getPrimaryKeys(connection.getCatalog(),
                connection.getSchema(), tableName);

        while (resultSet.next()) {
            for (Column column : table.getColumnList()) {
                if (StringUtils.equals(column.getSqlName(), Str(resultSet, "COLUMN_NAME"))) {
                    primaryKeys = primaryKeys == null ? new PrimaryKeys() : primaryKeys;
                    primaryKeys.addColumn(column);
                    String pkName = resultSet.getString("PK_NAME");
                    pkName = StringUtils.isBlank(pkName) ? column.getSqlName() : pkName;
                    primaryKeys.setPkName(CamelCaseUtils.toCapitalizeCamelCase(pkName));
                }
            }
        }
        table.setPrimaryKeys(primaryKeys);
    }

    private String getJavaType() {
        return "";
    }
    private String Str(ResultSet resultSet, String column) throws SQLException {
        return StringUtils.upperCase(resultSet.getString(column));
    }


    private String Str(ResultSet resultSet, String column, String defaultVal) throws SQLException {
        String val = Str(resultSet, column);
        return StringUtils.isBlank(val) ? defaultVal : val;
    }
}
