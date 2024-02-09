package com.myframework.pages;

import com.myframework.base.BaseClass;
import com.myframework.utitlies.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* @author : Shrikant
* Use for : This is a Homepage class contains web elements and methods associate with it.
* */
public class HomePage extends BaseClass implements Pages {

    public HashMap<String, WebElement> menuHashMap = new HashMap<String, WebElement>();
    public MenuSection menuSection;

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(xpath = "//a[@title='Contact us']")
    WebElement contactUsBtn;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement searchBtn;

    @FindBy(xpath = "//ul[contains(@class,'sf-menu')]/li/a")
    List<WebElement> pageMenu;

    /*
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a") //  //div[@id='block_top_menu']/ul/li/a
    WebElement menuWomen;

        @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[1]")
        WebElement menuWomenTops;

        @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[1]/ul/li[1]")
        WebElement menuWomenTopsTshirt;

        @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[1]/ul/li[2]")
        WebElement menuWomenTopsBlouses;

        @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[2]/a")
        WebElement menuWomenDresses;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
    WebElement menuDresses;
    */

    public HomePage(){
        PageFactory.initElements(getDriver(), this);
        menuSection = new MenuSection();
        //System.out.println("Here getting hashmap "+menuSection.getPageMenu());
        //homePageMenu();
    }

    /*
    public void homePageMenu(){
        menuHashMap.put("menuWomen",menuWomen); // FirstMenu
            menuHashMap.put("menuWomenTops",menuWomenTops); // FirstMenu->submenu
                menuHashMap.put("menuWomenTopsTshirt",menuWomenTopsTshirt); // FirstMenu->submenu->submenu
                menuHashMap.put("menuWomenTopsBlouses",menuWomenTopsBlouses); // // FirstMenu->submenu->submenu
            menuHashMap.put("menuWomenDRESSES",menuWomenDresses); // FirstMenu->submenu
        menuHashMap.put("menuDresses",menuDresses);
        //System.out.println("The Mappings are: " + menuHashMap);
    } */


    @Override
    public String getPageTitle(){
        return Util.pageTitle();
    }

    public Boolean isSignInBtnDisplayed(){
        return Util.isElementDisplayed(signInBtn);
    }

    public SignInSIgnup clickOnSignInbtn(){
        Util.clickOn(signInBtn);
        return new SignInSIgnup();
    }

    public List<String> getMenuOnHomePage(){
        List<String> menuOnHomePage= new ArrayList<>();
        for(WebElement menu : pageMenu){
            menuOnHomePage.add(Util.getText(menu));
        }
        return menuOnHomePage;
    }

    public boolean verifyMainMenuOptions(List HOME_PAGE_MENU){
        //check count of menu; if count not match return fasle
        List<String> menuOnHomePage = getMenuOnHomePage();
        if(menuOnHomePage.size() != HOME_PAGE_MENU.size()){
            return false;
        }
        //checking if all menus are there in if not then return false else return true
        menuOnHomePage.removeAll(HOME_PAGE_MENU);
        return menuOnHomePage.isEmpty();
    }

    public boolean isSignInBtnClickable(int WAIT_TIME_20_SECOND){
        return Util.isElementClickable(signInBtn,WAIT_TIME_20_SECOND);
    }

    public ProductDetailPage hoverOnMenuAndSelectMenu(List<String> menuToSelect){
        menuHashMap = menuSection.getPageMenu();

        //System.out.println("Is the map empty? " + menuHashMap.isEmpty());
        //System.out.println("The Mappings are: " + menuHashMap);
        //System.out.println(menuHashMap.get("menuWomen"));

        StringBuffer menu = new StringBuffer();
        menu.append("menu");
        for (String m:menuToSelect) {
            menu.append(m);
            //System.out.println(menu);
            Util.hoverOn(menuHashMap.get(menu.toString()));
        }
        Util.performMouseClick(menuHashMap.get(menu.toString()));
        return new ProductDetailPage();
    }
}
