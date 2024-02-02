/*
@author: Shrikant
Use    : This is a utility class that contain common methods used accross the framework
* */
package com.myframework.utitlies;

import com.myframework.Interfaces.WebInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Utilities implements WebInterface {
    WebDriver driver;
    public Utilities (WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void launchWebsite(String url) {
        this.driver.get(url);
    }

    @Override
    public void exitTest() {
        this.driver.quit();
    }

    @Override
    public void implicitilyWait(int seconds) {
        System.out.println("printing driver: "+this.driver);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    @Override
    public void pageLoadTimeout(int seconds) {
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    @Override
    public void maximizeScreen(){
        this.driver.manage().window().fullscreen();
    }

    @Override
    public String pageTitle(){
        return driver.getTitle();
    }

    @Override
    public Boolean isElementVisible(WebElement e){
       return e.isDisplayed();
    }

    @Override
    public void clickOn(WebElement e){
        e.click();
    }
}
