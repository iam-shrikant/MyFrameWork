/*
@author : Shrikant
*/

package com.myframework.Interfaces;

import org.openqa.selenium.WebElement;

public interface WebInterface {
    // initiate browser to launch website provided in URL
    void launchWebsite(String url);

    // close all browser,tab or windows associated with test
    void exitTest();


    void implicitilyWait(int seconds);

    void pageLoadTimeout(int seconds);

    void maximizeScreen();

    String pageTitle();

    boolean isElementDisplayed(WebElement e);

    void clickOn(WebElement e);

    String getText(WebElement e);

    boolean isElementClickable(WebElement e,int waitTimeInSecond);

    void sendKeys(WebElement e, String text);

    boolean isElementVisible(WebElement e, int waitTimeInSecond);
}
