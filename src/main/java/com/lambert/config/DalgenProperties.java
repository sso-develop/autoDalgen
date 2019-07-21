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

    private static String projectDirectory;


    static {
        Properties prop = new Properties();

        try{
            FileInputStream in = new FileInputStream("db.properties");
            prop.load(in);

            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            projectDirectory = prop.getProperty("projectDirectory");
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

    public static String getProjectDirectory() {
        return projectDirectory;
    }

    public static void main(String[] args) {
        System.err.println(DalgenProperties.getDriver());

    }
}
