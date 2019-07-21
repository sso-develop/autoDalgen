package com.lambert.dalgen.mybatis.dataloaders;

import com.lambert.config.DalgenProperties;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.mybatis.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * @author lambert
 * @version $Id: DalgenTableLoader.java, v 0.1 2019年05月21日 8:47 PM lambert Exp $
 */
public class DalgenTableLoader extends AbstractDalgenLoader{

    private static final Logger logger = LoggerFactory.getLogger(DalgenTableLoader.class);

    private TableRepository tableRepository   = new TableRepository();

    public Table load(Connection connection) throws Exception {
        //String table = "uums_sys_app";
        String table = DalgenProperties.getTables();
        return tableRepository.gainTable(connection,table);
    }
}
