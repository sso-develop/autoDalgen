package com.lambert.dalgen.mybatis.dataloaders;

import com.lambert.dalgen.mybatis.model.config.CfTable;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.mybatis.repository.CfTableRepository;

/**
 * @author lambert
 * @version $Id: DalgenCfTableLoader.java, v 0.1 2019年05月25日 4:58 PM lambert Exp $
 */
public class DalgenCfTableLoader {

    public CfTable load() throws Exception {
        CfTableRepository cfTableRepository = new CfTableRepository();


        return cfTableRepository.gainCfTable();
    }
}
