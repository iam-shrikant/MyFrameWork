package com.myframework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    Properties prop = new Properties();
    WebDriver driver;
    @BeforeSuite
    void beforeSuit(){
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties"));
            //System.out.println(prop.getProperty("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
