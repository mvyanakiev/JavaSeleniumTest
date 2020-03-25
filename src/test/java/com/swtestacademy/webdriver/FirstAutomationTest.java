package com.swtestacademy.webdriver;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomationTest {
    static WebDriver driver;

    @BeforeClass
    public static void setupTest() {
        driver = SetupTest.setupDriver();
    }

    @Test
    public void titleTest(){

        driver.navigate().to("https://www.teknosa.com/");

        Assert.assertEquals("Title check failed!", "Teknosa | Herkes İçin Teknoloji - Teknosa Alışveriş Sitesi", driver.getTitle());

        driver.close();
        driver.quit();
    }
}