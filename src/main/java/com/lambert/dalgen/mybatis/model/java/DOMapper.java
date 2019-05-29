package com.lambert.dalgen.mybatis.model.java;

import com.lambert.dalgen.mybatis.model.java.domapper.DOMapperMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambert
 * @version $Id: DOMapper.java, v 0.1 2019年05月25日 9:55 PM lambert Exp $
 */
public class DOMapper extends Base{

    private List<DOMapperMethod> motheds;

    public void addMothed(DOMapperMethod mothed) {
        if(this.motheds== null) this.motheds = new ArrayList<DOMapperMethod>();
        this.motheds.add(mothed);
    }

    public List<DOMapperMethod> getMotheds() {
        return motheds;
    }

    public void setMotheds(List<DOMapperMethod> motheds) {
        this.motheds = motheds;
    }
}
