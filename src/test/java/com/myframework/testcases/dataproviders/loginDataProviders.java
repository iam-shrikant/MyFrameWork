package com.myframework.testcases.dataproviders;

import org.testng.annotations.DataProvider;

public class loginDataProviders {
    @DataProvider(name="invalidLoginData")
    public Object[][] invalidLoginData(){
        Object[][] loginData = {
                {"test@testqa.com","Testing@12345"},  // invalid user
                {"test124@testqa.com","Testing@1222345"} // invalid user
        };
        return loginData;
    }

    @DataProvider(name="validLoginData")
    public Object[][] validLoginData(){
        Object[][] loginData = {
                {"test@testqa.com","Testing@1234"}// invalid user
        };
        return loginData;
    }
}
