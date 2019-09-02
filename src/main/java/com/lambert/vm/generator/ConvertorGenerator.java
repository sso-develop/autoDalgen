package com.lambert.vm.generator;

import com.lambert.config.DalgenProperties;
import com.lambert.dalgen.mybatis.model.java.Model;
import com.lambert.dalgen.mybatis.model.java.XmlMapper;
import com.lambert.vm.TemplateGenerator;

import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: ConvertorGenerator.java, v 0.1 2019年09月02日 11:10 PM lambert Exp $
 */
public class ConvertorGenerator extends TemplateGenerator {

    private XmlMapper xmlMapper;

    public ConvertorGenerator(String vm, XmlMapper xmlMapper) {
        super(vm);
        this.xmlMapper = xmlMapper;
    }

    @Override
    protected void setPath() {
        Model modelClass = xmlMapper.getModelClass();
        super.path = DalgenProperties.getConvertorDirectory() +"/"+modelClass.getClassName()+"Convertor.java";

    }

    @Override
    protected void createContext() throws SQLException {
        ctx.put("DO", xmlMapper.getDoClass());
        ctx.put("packageName", DalgenProperties.getConvertorPackageName());
        ctx.put("className", xmlMapper.getModelClass().getClassName()+"Convertor");

    }

    @Override
    public void run() throws SQLException {
        super.run();
    }
}
