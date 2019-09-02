package com.lambert.vm.generator;

import com.lambert.dalgen.mybatis.model.java.Model;
import com.lambert.vm.TemplateGenerator;

import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: ModelGenerator.java, v 0.1 2019年09月01日 9:39 AM lambert Exp $
 */
public class ModelGenerator extends TemplateGenerator {

    private Model modelClass;

    public ModelGenerator(String vm, Model modelClass) {
        super(vm);
        this.modelClass = modelClass;
    }

    @Override
    protected void setPath() {
        super.path = modelClass.getClassPath()+"/"+modelClass.getClassName()+".java";
    }

    @Override
    protected void createContext() throws SQLException {
        ctx.put("model", modelClass);
    }

    @Override
    public void run() throws SQLException {
        super.run();
    }
}
