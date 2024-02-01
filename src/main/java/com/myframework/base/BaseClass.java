/*
@author : Shrikant
*/

package com.myframework.base;

import com.myframework.utitlies.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    Properties prop = new Properties();
    WebDriver driver;
    Utilities util;
    public void setupDriver(){
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties"));
            //System.out.println(prop.getProperty("url"));
            if(prop.getProperty("browser") == "Chrome"){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(prop.getProperty("browser") == "Firefox"){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchWebsite(){
        util = new Utilities(driver);
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
