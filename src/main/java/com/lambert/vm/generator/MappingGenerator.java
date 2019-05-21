package com.lambert.vm.generator;

import com.lambert.vm.TemplateGenerator;
import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: MappingGenerator.java, v 0.1 2019年05月09日 11:00 PM lambert Exp $
 */
public class MappingGenerator extends TemplateGenerator {

    public MappingGenerator(String vm) {
        super(vm);
    }

    @Override
    protected void setPath() {
        if(StringUtils.isBlank(super.path)){
            super.path = "sqlmap-mapping.xml";
        }else{
            super.path = super.path +"sqlmap-mapping.xml";
        }

    }

    @Override
    protected void createContext() throws SQLException {


        ctx.put("name", "lin");
    }

}
