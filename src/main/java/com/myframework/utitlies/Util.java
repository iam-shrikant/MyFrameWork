package com.myframework.utitlies;

import com.myframework.base.Log;
import com.myframework.driver_factory.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Util {

    public static void launchWebsite(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void exitTest() {
        DriverManager.getDriver().quit();
    }

    public static void implicitilyWait(int seconds) {
        //System.out.println("printing driver: "+this.driver);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void pageLoadTimeout(int seconds) {
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    public static void maximizeScreen(){
        DriverManager.getDriver().manage().window().maximize();
    }


    public static String pageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    public static boolean isElementDisplayed(WebElement e){
        return e.isDisplayed();
    }
    public static void clickOn(WebElement e){
        e.click();
    }

    public static String getText(WebElement e){
        return e.getText();
    }

    public static void waitElementToBeVisible(WebElement e, int seconds){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void checkElementToBeVisibleByFluetWait(WebElement e, int seconds){
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class)
                .withMessage("Element Not yet visible");

        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static boolean isElementClickable(WebElement e, int WAIT_TIME_20_SECOND){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_TIME_20_SECOND));
            wait.until(ExpectedConditions.elementToBeClickable(e));
            //System.out.println("shrikant No Error -- ");
            return true;
        }
        catch(TimeoutException exception) {
            //System.out.println("shrikant error -- "+exception.getMessage());
            return false;
        }
    }

    public static void sendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static boolean isElementVisible(WebElement element,int WAIT_TIME_20_SECOND){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(WAIT_TIME_20_SECOND));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static void hoverOn(WebElement element,int WAIT_TIME_20_SECOND){
        Actions action = new Actions(DriverManager.getDriver());
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(WAIT_TIME_20_SECOND));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            action.moveToElement(element).build().perform();
        }catch (MoveTargetOutOfBoundsException e){
            Log.error("Util - hoverOn(): Got Exception:",e);
            e.printStackTrace();
        }
    }

    public static void performMouseClick(WebElement element,int WAIT_TIME_10_SECOND){
        Actions action = new Actions(DriverManager.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(WAIT_TIME_10_SECOND));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.moveToElement(element).click().build().perform();
    }

    public static void selectOptionByText(WebElement element,String text){
        Select sortBy = new Select(element);
        sortBy.selectByVisibleText(text);
    }

    public static void scrollPageTillElementUsingJS(WebElement element){
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        //Thread.sleep(500);
    }
}
