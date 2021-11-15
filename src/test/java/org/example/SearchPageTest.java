package org.example;

import org.junit.Test;

public class SearchPageTest extends LoginPageTest{

    @Test
    public void search(){
        super.login();
        new SearchPage(driver,js).search("pantolan"); //Search
        new SearchPage(driver,js).selectRandomProduct();    //Select random product from list
    }
}
