package com.myframework.pages;

import com.myframework.base.BaseClass;
import com.myframework.utitlies.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
        PageFactory.initElements(getDriver(), this);
        menuSection = new MenuSection();
    }

    @Override
    public String getPageTitle() {
        return Util.pageTitle();
    }

    public boolean verifyPageBreadCrumb(List<String> menuSelection){
        String[] breadCrumb = Util.getText(pageBreadCrumb).split(">");
        //System.out.println(Arrays.toString(breadCrumb));
        //System.out.println(menuSelection);
        return menuSelection.equals(Arrays.asList(breadCrumb));
    }

    public void scrollPageTillSortByOption(){
        Util.scrollPageTillElementUsingJS(sortBy);
    }

    public boolean selectSortOptionByText(String sortByText){
        Util.selectOptionByText(sortBy,sortByText);
        return true;
    }

    public void getAllProductList(){
        List<Integer> prodPrice = new ArrayList<>();
        for (WebElement product: productList) {

            //System.out.println(product.getText());
            //String price = product.findElement(By.xpath("./div/div[2]/h5/a")).getText();
            String price = product.findElement(By.xpath("./div/div[2]/div[@class='content_price']/span[@class='price product-price']")).getText().replace("$","");
            prodPrice.add(Integer.parseInt(price));

        }
        System.out.println(prodPrice);
    }

}
