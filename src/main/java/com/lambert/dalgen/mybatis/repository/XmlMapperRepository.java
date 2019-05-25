package com.lambert.dalgen.mybatis.repository;

import com.lambert.dalgen.mybatis.model.config.CfTable;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.mybatis.model.java.XmlMapper;

import java.beans.XMLDecoder;

/**
 * @author lambert
 * @version $Id: XmlMapperRepository.java, v 0.1 2019年05月25日 5:52 PM lambert Exp $
 */
public class XmlMapperRepository {

    public XmlMapper gain(CfTable cfTable){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setCfTable(cfTable);
        return xmlMapper;
    }
}
