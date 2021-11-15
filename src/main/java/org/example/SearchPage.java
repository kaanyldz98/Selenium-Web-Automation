package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SearchPage extends LoginPage{

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    JavascriptExecutor js;

    public SearchPage(WebDriver webDriver, JavascriptExecutor js){

        super(webDriver,js);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,30,150);
        this.js = js;

    }
    public void search(String searchKey){

        WebElement searchData = webDriver.findElement(By.id("search_input"));       //Search field found
        webDriver.findElement(By.id("search_input")).clear();                           //Search field cleared for search
        searchData.sendKeys(searchKey);                                         //The search word has been inserted
        searchData.sendKeys(Keys.ENTER);                                                        //Searched
        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);             //Ctrl + END for scroll down to bottom
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("lazy-load-button"))).click();//“Daha fazla ürün gör“ button clicked

    }
    public void selectRandomProduct(){

        //List all products in a list and select one of them randomly
        List<WebElement> allProducts = webDriver.findElements(By.xpath("//*[@class='col-xs-6 col-sm-6 col-md-3 four-column c-item product-item-wrapper']"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());

        //Product details page
        allProducts.get(randomProduct).click();
        WebElement price = webDriver.findElement(By.className("basket-discount"));
        System.out.println(price.getAttribute("innerText"));

        //webDriver.findElement(By.id("pd_add_to_cart")).click();
        //webDriver.findElement(By.className("button-link")).click();
    }
}
