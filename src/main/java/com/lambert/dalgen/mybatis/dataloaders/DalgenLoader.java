package com.lambert.dalgen.mybatis.dataloaders;

import com.lambert.dalgen.mybatis.datasources.DBConnectionFactory;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.mybatis.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * @author lambert
 * @version $Id: DalgenLoader.java, v 0.1 2019年05月21日 8:47 PM lambert Exp $
 */
public class DalgenLoader extends AbstractDalgenLoader{

    private static final Logger logger = LoggerFactory.getLogger(DalgenLoader.class);

    private TableRepository tableRepository   = new TableRepository();

    public Table load(Connection connection) throws Exception {
        String table = "uums_sys_app";
        return tableRepository.gainTable(connection,table);
    }
}
