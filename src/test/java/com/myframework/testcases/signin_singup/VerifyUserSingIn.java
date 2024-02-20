package com.myframework.testcases.signin_singup;


import com.myframework.pages.AccountPage;
import com.myframework.pages.SignInSIgnup;
import com.myframework.testcases.basetest.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class VerifyUserSingIn extends BaseTestClass {
    //tc1: verify sign-in button is visible or not
    //tc2: verify user is able to click on sign-in button
    //tc3: verify user tap on sign-in button
    //tc4: verify user provided wrong login details
    //tc5: verify user provided correct login details
    //tc6: verify login successful
    //tc7: Verify Logout
    private SignInSIgnup signInSignUpPage;
    private AccountPage accountPage;

    @Test(priority = 1,groups = {"smoke"})
    public void verifySignInBtnIsVisible(){
        Assert.assertTrue(homePage.isSignInBtnDisplayed());
    }

    @Test(priority = 2)
    public void verifySignInBtnIsClickable(){
        Assert.assertTrue(homePage.isSignInBtnClickable(WAIT_TIME_20_SECOND));
    }

    @Test(priority = 3)
    public void verifyUserTapOnSignInBtn(){
        signInSignUpPage = homePage.clickOnSignInbtn();
    }

    @Test(priority = 4, dataProvider = "invalidLoginData", dataProviderClass = com.myframework.testcases.dataproviders.loginDataProviders.class)
    public void verifyInvalidUserLogin(String emailId, String password){
        SoftAssert softAssert = new SoftAssert();
        signInSignUpPage.enterEmailAddress(emailId);
        signInSignUpPage.enterPassword(password);
        signInSignUpPage.clickOnSignInbtn();
        softAssert.assertTrue(signInSignUpPage.isErrorDisplayed());
        softAssert.assertEquals("Authentication failed.",signInSignUpPage.readError(),"Validation error");
        softAssert.assertAll();
    }

    @Test(priority = 5, dataProvider = "validLoginData", dataProviderClass = com.myframework.testcases.dataproviders.loginDataProviders.class)
    public void verifyValidUserLogin(String emailId, String password){
        //SoftAssert softAssert = new SoftAssert();
        signInSignUpPage.enterEmailAddress(emailId);
        signInSignUpPage.enterPassword(password);
        accountPage = signInSignUpPage.clickOnSignInbtn();
        Assert.assertEquals(AccountPage.expectedPageTitle,accountPage.getPageTitle());
    }

    @Test(priority = 6)
    public void verifyUserSignOut(){
        signInSignUpPage = accountPage.signOutUser();
        Assert.assertEquals(signInSignUpPage.expectedPageTitle,signInSignUpPage.getPageTitle());
    }
}
