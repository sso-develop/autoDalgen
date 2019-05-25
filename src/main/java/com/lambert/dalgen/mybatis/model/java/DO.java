package com.lambert.dalgen.mybatis.model.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: DO.java, v 0.1 2019年05月25日 9:08 PM lambert Exp $
 */
public class DO extends Base{

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
