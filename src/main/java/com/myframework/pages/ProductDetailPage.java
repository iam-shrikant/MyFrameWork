package com.myframework.pages;

import com.myframework.base.BaseClass;
import com.myframework.driver_factory.DriverManager;
import com.myframework.utitlies.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class ProductDetailPage extends BaseClass implements Pages {
    public HashMap<String, WebElement> menuHashMap = new HashMap<String, WebElement>();
    public MenuSection menuSection;

    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]/span[@class='navigation_page']")
    WebElement pageBreadCrumb;

    @FindBy(id = "selectProductSort")
    WebElement sortBy;

    @FindBy(xpath = "//ul[@class ='product_list grid row']/li")
    List<WebElement> productList;


    public ProductDetailPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
        menuSection = new MenuSection();
    }

    @Override
    public String getPageTitle() {
        return Util.pageTitle();
    }

    public boolean verifyPageBreadCrumb(List<String> menuSelection){
        Util.checkElementToBeVisibleByFluetWait(pageBreadCrumb, WAIT_TIME_20_SECOND);
        String[] breadCrumb = Util.getText(pageBreadCrumb).split(">");
        return menuSelection.equals(Arrays.asList(breadCrumb));
        //System.out.println(Arrays.toString(breadCrumb));
        //System.out.println(menuSelection);
    }

    public void scrollPageTillSortByOption(){
        Util.scrollPageTillElementUsingJS(sortBy);
    }

    public boolean selectSortOptionByText(String sortByText){
        Util.selectOptionByText(sortBy,sortByText);
        return true;
    }

    public int[] getProductPriceData(){
        int[] productPriceData = new int[productList.size()];
        int i = 0;
        for (WebElement product: productList) {
            try {
                productPriceData[i] = Integer.parseInt(product.findElement(By.xpath("./div/div[2]/div[@class='content_price']/span[@class='price product-price']")).getText().replace("$",""));
                i++;
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }

        }
        return productPriceData;
    }

    public boolean isProductSortedByLowPriceFirst(){
        int[] productData = getProductPriceData();
        boolean ascending = true;
        for (int j = 1; j < productData.length && ascending; j++) {
            ascending = ascending && productData[j] >= productData[j-1];
        }
        return ascending;
    }

    public boolean isProductSortedByHighestPriceFirst(){
        int[] productData = getProductPriceData();
        boolean descending = true;
        for (int j = 1; j < productData.length && descending; j++) {
            descending = descending && productData[j] <= productData[j-1];
        }
        return descending;
    }

    public boolean isProductSortBy(String sortByText){
        //int[] productData = new int[productList.size()];
        if(sortByText.equals("Price: Lowest first")){
            return isProductSortedByLowPriceFirst();
        }else if(sortByText.equals("Price: Highest first")){
            return isProductSortedByHighestPriceFirst();
        }else{
            return false;
        }
    }

}
