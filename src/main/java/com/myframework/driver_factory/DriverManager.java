package com.myframework.driver_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverManager { //no one should able to extend this class

    private DriverManager(){
        //not allowing anyone to create object of this class
    }

    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            driver.set(new ChromeDriver());
        }else if(browserName.equalsIgnoreCase("Firefox")){
            driver.set(new ChromeDriver());
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void unload(){
        driver.remove();
    }
}
