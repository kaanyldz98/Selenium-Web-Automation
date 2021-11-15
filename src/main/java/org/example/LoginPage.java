package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class LoginPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    JavascriptExecutor js;

    public LoginPage(WebDriver webDriver, JavascriptExecutor js){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,30,150);
        this.js = js;
    }

    public void login(String username, String password){

        webDriver.manage().deleteAllCookies();
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR"); //Homepage
        Assert.assertEquals("LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki", webDriver.getTitle()); //Check homepage
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("dropdown-toggle"))).click();  //Sign in button
        Assert.assertEquals("Üye Girişi - LC Waikiki", webDriver.getTitle()); //Check sign in page

        webDriver.findElement(By.id("LoginEmail")).clear(); //Clear the field for email
        webDriver.findElement(By.id("LoginEmail")).sendKeys(username); //Email placed
        webDriver.findElement(By.id("Password")).clear(); //Clear the field for password
        webDriver.findElement(By.id("Password")).sendKeys(password); //Password placed

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("loginLink"))).click(); //Login button clicked
        Assert.assertEquals("LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki", webDriver.getTitle());//Cack to home page checked
    }
}
