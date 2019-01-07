package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class WindowHandlesTest {

    static WebDriver driver;
    private String testUrl = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target";

    @BeforeClass
    public static void setupTest() {
        driver = SetupTest.setupDriver();
    }



//todo
// https://www.swtestacademy.com/selenium-webdriver-windows/





    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
