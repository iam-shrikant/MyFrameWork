package com.myframework.testcases.product;

import com.myframework.base.BaseClass;
import com.myframework.pages.HomePage;
import com.myframework.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class verifySortByOnProduct extends BaseClass {

    //tc1: Open a url on browser
    //tc2: Hover on Women Menu -> Tap on Dress
    //tc3: verify breadcrumb on page is as per menu selection
    //tc4: scroll page upto Sort by drop down
    //tc5: Tap on Sort drop down and select price lowest First
    //tc6: Verify product should get sorted in lowest price first


    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    public List<String> menuSelection = new ArrayList<>(Arrays.asList("Women","Dresses"));
    public String sortByText = "Price: Lowest first";

    @BeforeClass()
    public void beforeClass(){
        //System.out.println("verifySortByOnProduct - Before Class");
        setupDriver();
        launchWebsite();
        homePage = new HomePage();
    }


    @Test(priority = 1)
    public void hoverOnMenuAndSelectMenu(){
        productDetailPage = homePage.hoverOnMenuAndSelectMenu(menuSelection);
    }

    @Test(priority = 2)
    public void verifyPageBreadCrumb(){
         Assert.assertTrue(productDetailPage.verifyPageBreadCrumb(menuSelection));
    }

    @Test(priority = 3)
    public void selectSortOptionByText(){
        Assert.assertTrue(productDetailPage.selectSortOptionByText(sortByText));
    }

    @Test(priority = 4)
    public void scrollPageTillSortByOption(){
        productDetailPage.scrollPageTillSortByOption();
    }

    @Test(priority = 5)
    public void verifyProductOrder(){
        productDetailPage.getAllProductList();
    }

    /*
    @AfterClass
    public void afterClass(){
        //System.out.println("Thread NO : "+Thread.currentThread().getId());
        doEndTest();
    }*/
}
