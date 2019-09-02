package com.lambert;

import com.google.gson.Gson;
import com.lambert.dalgen.mybatis.dataloaders.DalgenCfTableLoader;
import com.lambert.dalgen.mybatis.dataloaders.DalgenTableLoader;
import com.lambert.dalgen.mybatis.dataloaders.DalgenXmlMapperLoader;
import com.lambert.dalgen.mybatis.model.config.CfTable;
import com.lambert.dalgen.mybatis.model.dbtable.Table;
import com.lambert.dalgen.mybatis.model.java.DOMapper;
import com.lambert.dalgen.mybatis.model.java.XmlMapper;
import com.lambert.vm.generator.*;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {


            DalgenTableLoader loader = new DalgenTableLoader();

            Table table = loader.load();

            System.err.println(gson.toJson(table));
            System.err.println("=====table====");

            InitTableXmlGenerator initTableXmlGenerator = new InitTableXmlGenerator("initTableXml.vm",table);
            initTableXmlGenerator.run();


            DalgenCfTableLoader cfTableLoader = new DalgenCfTableLoader();
            CfTable cfTable = cfTableLoader.load();
            System.err.println(gson.toJson(cfTable));

            DalgenXmlMapperLoader dalgenXmlMapperLoader = new DalgenXmlMapperLoader();
            XmlMapper xmlMapper = dalgenXmlMapperLoader.load(cfTable);
            System.err.println(gson.toJson(xmlMapper));
            System.err.println("=====xmlMapper====");

            XmlMapperGenerator xmlMapperGenerator = new XmlMapperGenerator("XMLMapper.vm",xmlMapper);
            xmlMapperGenerator.run();


            DOGenerator doGenerator = new DOGenerator("DO.vm",xmlMapper.getDoClass());
            doGenerator.run();

            DOMapperGenerator doMapperGenerator = new DOMapperGenerator("DOMapper.vm",xmlMapper.getDoMapper());
            doMapperGenerator.run();


            ModelGenerator modelGenerator = new ModelGenerator("model.vm",xmlMapper.getModelClass());
            modelGenerator.run();

    }catch (Exception e){
            e.printStackTrace();
        }

    }
}
