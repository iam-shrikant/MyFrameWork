/*
@author : Shrikant
*/

package com.myframework.base;

import com.myframework.utitlies.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.javadoc.doclet.Reporter;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static  Properties prop = new Properties();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static Utilities util;
    public final int WAIT_TIME_10_SECOND = 10;
    public final int WAIT_TIME_20_SECOND = 20;

    public static void setupDriver(){
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties"));
            if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
                System.out.println("setting up chrome driver");
                //WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                //driver = new ChromeDriver();

                //driver = WebDriverManager.chromedriver().create();
            }else if(prop.getProperty("browser") == "Firefox"){
                WebDriverManager.firefoxdriver().setup();
                //driver = new FirefoxDriver();
                driver.set(new FirefoxDriver());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void unload(){
        driver.remove();
    }

    public void launchWebsite(){
        util = new Utilities();
        util.implicitilyWait(WAIT_TIME_10_SECOND);
        util.pageLoadTimeout(WAIT_TIME_20_SECOND);
        util.launchWebsite(prop.getProperty("url"));
        util.maximizeScreen();
    }

    public void doEndTest(){
        if(util != null){
            util.exitTest();
            driver.remove();
        }else{
            System.out.println("util object is null");
        }
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }
}
