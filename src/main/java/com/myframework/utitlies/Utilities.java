/*
@author: Shrikant
Use    : This is a utility class that contain common methods used accross the framework
* */
package com.myframework.utitlies;

import com.myframework.Interfaces.WebInterface;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public boolean isElementVisible(WebElement e){
       return e.isDisplayed();
    }

    @Override
    public void clickOn(WebElement e){
        e.click();
    }

    @Override
    public String getText(WebElement e){ return e.getText();}

    @Override
    public boolean isElementClickable(WebElement e, int WAIT_TIME_20_SECOND){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_20_SECOND));
            wait.until(ExpectedConditions.elementToBeClickable(e));
            return true;
        }
        catch(TimeoutException exception) {
            return false;
        }
    }
}
