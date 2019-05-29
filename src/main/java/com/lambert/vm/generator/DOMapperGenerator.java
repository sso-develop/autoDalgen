package com.lambert.vm.generator;

import com.lambert.dalgen.mybatis.model.java.DOMapper;
import com.lambert.vm.TemplateGenerator;
import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: DOMapperGenerator.java, v 0.1 2019年05月29日 8:07 PM lambert Exp $
 */
public class DOMapperGenerator  extends TemplateGenerator {

    DOMapper doMapper;

    public DOMapperGenerator(String vm,DOMapper doMapper) {
        super(vm);
        this.doMapper = doMapper;
    }

    @Override
    protected void setPath() {
        if(StringUtils.isBlank(super.path)){
            super.path = doMapper.getClassName()+".java";
        }else{
            super.path = super.path +doMapper.getClassName()+".java";
        }
    }

    @Override
    protected void createContext() throws SQLException {
        ctx.put("doMapper",doMapper);
    }
}
