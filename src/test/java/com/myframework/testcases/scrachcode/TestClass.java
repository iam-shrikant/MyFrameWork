package com.myframework.testcases.scrachcode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestClass {



    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        /*
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        //driver.get(" https://www.flipkart.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement pageMenu = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a"));



        System.out.println("End of testing");
        //driver.quit();
        */
        int[] productData = {4,6,9,8,10};
        boolean ascending = true, descending = true;
        for (int j = 1; j < productData.length && (ascending || descending); j++) {
            ascending = ascending && productData[j] >= productData[j-1];
            descending = descending && productData[j] <= productData[j-1];
        }
        System.out.println(ascending+" "+descending);
    }
}
