package com.lambert.config;

import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author lambert
 * @version $Id: DalgenProperties.java, v 0.1 2019年07月21日 3:35 PM lambert Exp $
 */
public class DalgenProperties {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    private static String tables;

    private static String projectDirectory;

    private final static String basePackagePath = "/src/main/java/com/lambert/common";

    private final static String basePackage = "com.lambert.common";

    private final static String resourcesPath = "/resources";

    private final static String projectDaoPath = "/app/common/dal";

    private final static String autoDalgenDOPath = basePackagePath+"/uums/dal/dataobject";

    private final static String autoDalgenDOMapperPath = basePackagePath+"/uums/dal/daointerface";

    private final static String autoDalgenXmlMapperPath  = basePackagePath+"/uums/dal/daointerface";




    static {
        Properties prop = new Properties();

        try{
            String path = ClassLoader.getSystemResource("db.properties").getPath();

            FileInputStream in = new FileInputStream(path);

            prop.load(in);

            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            projectDirectory = prop.getProperty("projectDirectory");
            tables = prop.getProperty("tables");
            in.close();

        }catch (Exception e){
           e.printStackTrace();
        }

    }

    public static String getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getTables() {
        return tables;
    }

    private static String getProjectDirectory() {
        return projectDirectory;
    }

    public static String getDODirectory(){
        return getProjectDirectory()+autoDalgenDOPath;
    }


    public static void main(String[] args) {
        System.err.println(DalgenProperties.getDriver());

    }
}
