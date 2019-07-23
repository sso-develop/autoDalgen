package com.lambert.config;

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

    private static String projectName;

    private static String projectDirectory;

    private final static String basePackagePath = "/src/main/java/com/lambert";

    private final static String resourcesPath = "/src/main/resources";

    private final static String projectDaoPath = "/app/common/dal";




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
            projectName = prop.getProperty("projectName");
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


    private static String getDalClassDirectory(){
        return projectDirectory+projectDaoPath+basePackagePath+"/"+projectName+"/common/dal";
    }

    private static String getDalResourcesDirectory(){
        return projectDirectory+projectDaoPath+resourcesPath;
    }

    public static String getDODirectory(){
        return getDalClassDirectory()+"/dataobject";
    }

    public static String getDOMapperDirectory(){
        return getDalClassDirectory()+"/daointerface";
    }
    public static String getDalgenDirectory(){
        return projectDirectory+"/dalgen";
    }


    public static void main(String[] args) {
        System.err.println(DalgenProperties.getDODirectory());
        System.err.println(DalgenProperties.getDOMapperDirectory());
        System.err.println(DalgenProperties.getDalResourcesDirectory());
        System.err.println(DalgenProperties.getDalgenDirectory());
    }
}
