package com.myframework.pages;

import com.myframework.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
* @author : Shrikant
* Use for : This is a Homepage class contains web elements and methods associate with it.
* */
public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@class=\"login\"]")
    WebElement signInBtn;

    @FindBy(xpath = "//a[@title='Contact us']")
    WebElement contactUsBtn;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement searchBox;


    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement searchBtn;

    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String getPageTitle(){
        return util.pageTitle();
    }

    public Boolean isSignInBtnDisplayed(){
        return util.isElementVisible(signInBtn);
    }

    public void clickOnSignInbtn(){
        util.clickOn(signInBtn);
    }
}
