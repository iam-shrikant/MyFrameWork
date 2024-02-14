/*
@author : Shrikant
*/

package com.myframework.base;

import com.myframework.driver_factory.DriverManager;
import com.myframework.utitlies.Util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static  Properties prop = new Properties();

    //public static Utilities util;
    public final int WAIT_TIME_10_SECOND = 10;
    public final int WAIT_TIME_20_SECOND = 20;

    private synchronized void loadProperties(){
        Log.info("BaseClass - loadProperties() initiated");
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties"));
        } catch (IOException e) {
            Log.info("BaseClass - loadProperties() Got Exception - "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void setupDriver(String browser){
        Log.info("BaseClass - setupDriver() initiated");
        loadProperties();
        DriverManager.setDriver(browser);
    }

    /* Driver setup code is moved to DriverManager class in driver_factory package
    public void setupDriver(){
        try {
            Log.info("BaseClass - setupDriver() initiated");
            loadProperties();
            if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
                //System.out.println("");
                Log.info("setting up chrome driver");
                //WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                //driver = new ChromeDriver();

            }else if(prop.getProperty("browser").equalsIgnoreCase("Firefox")){
                Log.info("setting up firefox driver");
                WebDriverManager.firefoxdriver().setup();
                //driver = new FirefoxDriver();
                driver.set(new FirefoxDriver());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.info("BaseClass - setupDriver(): Got Exception -"+e.getMessage());
        }
    }


    public static WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    public static void unload(){
        //driver.remove();
        DriverManager.unload();
    }*/


    public void launchWebsite(){
       // util = new Utilities();
        Util.implicitilyWait(WAIT_TIME_10_SECOND);
        Util.pageLoadTimeout(WAIT_TIME_20_SECOND);
        Util.launchWebsite(prop.getProperty("url"));
        Util.maximizeScreen();
    }

    public void doEndTest(){
        Util.exitTest();
        DriverManager.unload();
    }

}
