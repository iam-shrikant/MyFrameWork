package com.myframework.testcases.dataproviders;

import org.testng.annotations.DataProvider;

public class productDataProvide {
    @DataProvider
    public Object[][] menuSelectionData(){
        Object[][] loginData = {
                {"Women","DRESSES"}
        };
        return loginData;
    }
}
