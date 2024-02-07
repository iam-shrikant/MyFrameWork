package com.myframework.pages;

import com.myframework.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInSIgnup extends BaseClass {
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement passwd;

    @FindBy(id = "SubmitLogin")
    WebElement SubmitLogin;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]/ol/li")
    WebElement errorText;

    public SignInSIgnup(){
        PageFactory.initElements(getDriver(),this);
    }

    public void enterEmailAddress(String emailAddress){
        util.sendKeys(email,emailAddress);
    }

    public void enterPassword(String password){
        util.sendKeys(passwd,password);
    }

    public AccountPage clickOnSignInbtn(){
        util.clickOn(SubmitLogin);
        return new AccountPage();
    }

    public boolean isErrorDisplayed(){
        return  util.isElementVisible(errorText,WAIT_TIME_10_SECOND);
    }

    public String readError(){
        return util.getText(errorText);
    }
}
