package com.myframework.pages;

import com.myframework.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BaseClass {

    public static final String pageTitle = "My account - My Shop";

    @FindBy(xpath = "//div[@id='center_column']/h1")
    WebElement pageName;


}