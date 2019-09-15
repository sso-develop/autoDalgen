package com.lambert.vm;

import com.lambert.tool.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

/**
 * @Auther: lambert
 * @Date: 2019/3/26 21:38
 * @Description:
 */
public abstract class TemplateGenerator {

    VelocityEngine ve;
    protected VelocityContext ctx;
    protected String path;
    Template template;



    public TemplateGenerator(String vm) {
        if(ve == null){
            ve = new VelocityEngine();
        }
        if(ctx == null){
            ctx = new VelocityContext();
        }


        StringUtils stringUtils = new StringUtils();

        ctx.put("stringUtils",stringUtils);

        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        ve.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        ve.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");

        ve.init();
        template = ve.getTemplate(vm);

    }

    protected abstract void setPath();

    protected abstract void createContext() throws SQLException;

    public void run() throws SQLException {
        setPath();
        createContext();
        merge();
    }

    private void merge() {
        StringWriter sw = new StringWriter();
        template.merge(ctx, sw);
        //System.out.println(sw.toString());

        PrintWriter writer = null;
        try {
            System.err.println("======="+path+"=======");
            writer = new PrintWriter(path);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}