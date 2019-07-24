package com.lambert.vm.generator;

import com.lambert.config.DalgenProperties;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.vm.TemplateGenerator;
import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: InitTableXmlGenerator.java, v 0.1 2019年05月09日 11:00 PM lambert Exp $
 */
public class InitTableXmlGenerator extends TemplateGenerator {

    private Table table;

    public InitTableXmlGenerator(String vm, Table table) {

        super(vm);
        this.table = table;

    }

    @Override
    protected void setPath() {
        super.path = DalgenProperties.getDalgenDirectory() +"/uums-sys-app.xml";

    }

    @Override
    protected void createContext() throws SQLException {

        ctx.put("dalgen", table);
    }

}
