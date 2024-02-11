/*
@author : Shrikant
*/

package com.myframework.base;

import com.myframework.utitlies.Util;
import com.myframework.utitlies.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.javadoc.doclet.Reporter;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static  Properties prop = new Properties();
    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    //public static Utilities util;
    public final int WAIT_TIME_10_SECOND = 10;
    public final int WAIT_TIME_20_SECOND = 20;

    public static void setupDriver(){
        try {
            Log.info("BaseClass - setupDriver() initiated");
            prop.load(new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties"));
            if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
                //System.out.println("");
                Log.info("setting up chrome driver");
                //WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                //driver = new ChromeDriver();

                //driver = WebDriverManager.chromedriver().create();
            }else if(prop.getProperty("browser") == "Firefox"){
                Log.info("setting up firefox driver");
                WebDriverManager.firefoxdriver().setup();
                //driver = new FirefoxDriver();
                driver.set(new FirefoxDriver());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.info("BaseClass - setupDriver(): Got Exception -"+e.getMessage());
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void unload(){
        driver.remove();
    }

    public void launchWebsite(){
       // util = new Utilities();
        Util.implicitilyWait(WAIT_TIME_10_SECOND);
        Util.pageLoadTimeout(WAIT_TIME_20_SECOND);
        Util.launchWebsite(prop.getProperty("url"));
        Util.maximizeScreen();
    }

    public void doEndTest(){
        Util.exitTest();
        driver.remove();
    }

}
