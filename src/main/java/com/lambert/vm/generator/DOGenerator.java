package com.lambert.vm.generator;

import com.lambert.dalgen.mybatis.model.java.DO;
import com.lambert.vm.TemplateGenerator;
import java.sql.SQLException;

/**
 * @author lambert
 * @version $Id: DOGenerator.java, v 0.1 2019年05月25日 9:40 PM lambert Exp $
 */
public class DOGenerator extends TemplateGenerator {

    private DO doClass;

    public DOGenerator(String vm, DO doClass) {
        super(vm);
        this.doClass = doClass;
    }

    @Override
    protected void setPath() {
        super.path = doClass.getClassPath()+"/"+doClass.getClassName()+".java";
    }

    @Override
    protected void createContext() throws SQLException {
        ctx.put("DO", doClass);
    }

    @Override
    public void run() throws SQLException {
        super.run();
    }
}
