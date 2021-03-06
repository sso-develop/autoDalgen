package com.lambert.vm.generator;

import com.lambert.config.DalgenProperties;
import com.lambert.dalgen.mybatis.model.java.XmlMapper;
import com.lambert.dalgen.utils.CamelCaseUtils;
import com.lambert.vm.TemplateGenerator;
import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: XmlMapperGenerator.java, v 0.1 2019年05月25日 5:46 PM lambert Exp $
 */
public class XmlMapperGenerator extends TemplateGenerator {

    private XmlMapper xmlMapper;

    public XmlMapperGenerator(String vm,XmlMapper xmlMapper) {
        super(vm);
        this.xmlMapper = xmlMapper;
    }

    @Override
    protected void setPath() {

        super.path = DalgenProperties.getDalResourcesDirectory() +"/"+CamelCaseUtils.toCapitalizeCamelCase(DalgenProperties.getTables())+"-sqlmap-mapping.xml";

    }

    @Override
    protected void createContext() throws SQLException {
        ctx.put("xmlMapper", xmlMapper);
    }

    @Override
    public void run() throws SQLException {
        super.run();
    }
}
