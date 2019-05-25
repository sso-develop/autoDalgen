package com.lambert.dalgen.mybatis.dataloaders;

import com.lambert.dalgen.mybatis.model.config.CfTable;
import com.lambert.dalgen.mybatis.model.java.XmlMapper;
import com.lambert.dalgen.mybatis.repository.XmlMapperRepository;

/**
 * @author lambert
 * @version $Id: DalgenXmlMapperLoader.java, v 0.1 2019年05月25日 5:53 PM lambert Exp $
 */
public class DalgenXmlMapperLoader {

    public XmlMapper load(CfTable cfTable){
        XmlMapperRepository xmlMapperRepository = new XmlMapperRepository();
        return xmlMapperRepository.gain(cfTable);
    }
}
