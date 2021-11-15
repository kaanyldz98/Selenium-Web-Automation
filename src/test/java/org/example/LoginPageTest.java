package org.example;

import org.junit.Test;


public class LoginPageTest extends PageTest{

    @Test
    public void login(){
        new LoginPage(driver,js).login("",""); // Email and password will be placed here
    }

}
