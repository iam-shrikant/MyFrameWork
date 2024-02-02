/*
@author : Shrikant
*/

package com.myframework.base;

import com.myframework.utitlies.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public Properties prop = new Properties();
    public static WebDriver driver;
    public static Utilities util;
    public void setupDriver(){
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties"));

            if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
                System.out.println("setting up chrome driver");
                //WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                //driver = WebDriverManager.chromedriver().create();
            }else if(prop.getProperty("browser") == "Firefox"){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void launchWebsite(){
        util = new Utilities(this.driver);
        util.implicitilyWait(10);
        util.pageLoadTimeout(20);
        util.launchWebsite(prop.getProperty("url"));
        util.maximizeScreen();
    }

    public void doEndTest(){
        if(util != null){
            util.exitTest();
        }else{
            System.out.println("util object is null");
        }
    }
}
