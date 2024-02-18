package com.myframework.testcases.dataproviders;

import com.myframework.utitlies.Log;
import com.myframework.utitlies.ExcelUtility;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class loginDataProviders {
    /*@DataProvider(name="invalidLoginData")
    public Object[][] invalidLoginData(){
        Object[][] loginData = {
                {"test@testqa.com","Testing@12345"},  // invalid user
                {"test124@testqa.com","Testing@1222345"} // invalid user
        };
        return loginData;
    }*/

    @DataProvider(name="invalidLoginData")
    public Object[][] invalidLoginData(){
        ExcelUtility excelUtility = new ExcelUtility();
        String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\";
        String fileName = "Master_data.xlsx";
        try {
            excelUtility.readExcel(filePath,fileName);
            return excelUtility.getAllDataBySheetName("Login_details",true);
        } catch (IOException e) {
            Log.error("loginDataProviders - invalidLoginData(): Got IOException ",e);
            e.printStackTrace();
        }
        return new Object[0][0];
        //return loginData;
    }

    @DataProvider(name="validLoginData")
    public Object[][] validLoginData(){
        Object[][] loginData = {
                {"test@testqa.com","Testing@1234"}// invalid user
        };
        return loginData;
    }
}
