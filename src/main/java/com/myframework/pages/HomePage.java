package com.myframework.pages;

import com.myframework.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/*
* @author : Shrikant
* Use for : This is a Homepage class contains web elements and methods associate with it.
* */
public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(xpath = "//a[@title='Contact us']")
    WebElement contactUsBtn;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement searchBtn;

    @FindBy(xpath = "//ul[contains(@class,'sf-menu')]/li/a")
    List<WebElement> pageMenu;

    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String getPageTitle(){
        return util.pageTitle();
    }

    public Boolean isSignInBtnDisplayed(){
        return util.isElementDisplayed(signInBtn);
    }

    public SignInSIgnup clickOnSignInbtn(){
        util.clickOn(signInBtn);
        return new SignInSIgnup();
    }

    public List<String> getMenuOnHomePage(){
        List<String> menuOnHomePage= new ArrayList<>();
        for(WebElement menu : pageMenu){
            menuOnHomePage.add(util.getText(menu));
        }
        return menuOnHomePage;
    }

    public boolean verifyMainMenuOptions(List HOME_PAGE_MENU){
        //check count of menu; if count not match return fasle
        List<String> menuOnHomePage = getMenuOnHomePage();
        if(menuOnHomePage.size() != HOME_PAGE_MENU.size()){
            return false;
        }
        //checking if all menus are there in if not then return false else return true
        menuOnHomePage.removeAll(HOME_PAGE_MENU);
        return menuOnHomePage.isEmpty();
    }

    public boolean isSignInBtnClickable(int WAIT_TIME_20_SECOND){
        return util.isElementClickable(signInBtn,WAIT_TIME_20_SECOND);
    }
}
