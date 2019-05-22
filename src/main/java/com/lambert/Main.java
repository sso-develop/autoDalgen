package com.lambert;

import com.google.gson.Gson;
import com.lambert.dalgen.mybatis.dataloaders.DalgenTableLoader;
import com.lambert.dalgen.mybatis.model.dbtable.Table;

public class Main {

    public static void main(String[] args) {
        try {

            DalgenTableLoader loader = new DalgenTableLoader();

            Table table = loader.load();
            Gson gson = new Gson();
            System.err.println(gson.toJson(table));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
