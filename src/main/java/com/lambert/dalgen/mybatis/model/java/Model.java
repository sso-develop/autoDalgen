package com.lambert.dalgen.mybatis.model.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: Model.java, v 0.1 2019年09月01日 9:39 AM lambert Exp $
 */
public class Model extends Base{

    private List<Filelds> fieldses;

    public void addFields(Filelds fields) {
        if(this.fieldses == null) this.fieldses = new ArrayList<Filelds>();
        this.fieldses.add(fields);
    }


    public List<Filelds> getFieldses() {
        return fieldses;
    }

    public void setFieldses(List<Filelds> fieldses) {
        this.fieldses = fieldses;
    }
}
