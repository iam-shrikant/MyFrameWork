package com.myframework.testcases.product;

import com.myframework.pages.ProductDetailPage;
import com.myframework.testcases.basetest.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class verifySortByOnProduct extends BaseTestClass {

    //tc1: Open a url on browser
    //tc2: Hover on Women Menu -> Tap on Dress
    //tc3: verify breadcrumb on page is as per menu selection
    //tc4: scroll page upto Sort by drop down
    //tc5: Tap on Sort drop down and select price lowest First
    //tc6: Verify product should get sorted in lowest price first


    private ProductDetailPage productDetailPage;
    public List<String> menuSelection = new ArrayList<>(Arrays.asList("Women","Dresses"));
    public String sortByText = "Price: Highest first";


    @Test(priority = 1,groups = {"smoke"})
    public void hoverOnMenuAndSelectMenu() {
        productDetailPage = homePage.hoverOnMenuAndSelectMenu(menuSelection);
    }

    @Test(priority = 2,groups = {"smoke"})
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
    public void verifyProductOrderBy(){
        Assert.assertTrue(productDetailPage.isProductSortBy(sortByText));
    }

}
