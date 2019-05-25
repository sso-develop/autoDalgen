package com.lambert;

import com.google.gson.Gson;
import com.lambert.dalgen.mybatis.dataloaders.DalgenCfTableLoader;
import com.lambert.dalgen.mybatis.dataloaders.DalgenTableLoader;
import com.lambert.dalgen.mybatis.dataloaders.DalgenXmlMapperLoader;
import com.lambert.dalgen.mybatis.model.config.CfTable;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.mybatis.model.java.XmlMapper;
import com.lambert.vm.generator.InitTableXmlGenerator;
import com.lambert.vm.generator.XmlMapperGenerator;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {


            DalgenTableLoader loader = new DalgenTableLoader();

            Table table = loader.load();

            System.err.println(gson.toJson(table));

            InitTableXmlGenerator initTableXmlGenerator = new InitTableXmlGenerator("initTableXml.vm",table);
            initTableXmlGenerator.run();


            DalgenCfTableLoader cfTableLoader = new DalgenCfTableLoader();
            CfTable cfTable = cfTableLoader.load();
            System.err.println(gson.toJson(cfTable));

//            DalgenXmlMapperLoader dalgenXmlMapperLoader = new DalgenXmlMapperLoader();
//            XmlMapper xmlMapper = dalgenXmlMapperLoader.load(cfTable);
//            System.err.println(gson.toJson(xmlMapper));
//
//            XmlMapperGenerator xmlMapperGenerator = new XmlMapperGenerator("XMLMapper.vm",xmlMapper);
//            xmlMapperGenerator.run();

    }catch (Exception e){
            e.printStackTrace();
        }

    }
}
