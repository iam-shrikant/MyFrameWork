package com.myframework.pages;

import com.myframework.base.BaseClass;
import com.myframework.utitlies.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BaseClass implements Pages {

    public static final String pageTitle = "My account - My Shop";

    @FindBy(xpath = "//div[@id='center_column']/h1")
    WebElement pageName;

    @Override
    public String getPageTitle(){
        return Util.pageTitle();
    }
}
