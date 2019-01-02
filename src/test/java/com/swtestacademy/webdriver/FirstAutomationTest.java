package com.swtestacademy.webdriver;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomationTest {

    @Test
    public void titleTest(){

        System.setProperty("webdriver.chrome.driver", ConstantsTests.CHROMEDRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.teknosa.com/");

        Assert.assertEquals("Title check failed!", "Teknosa | Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji", driver.getTitle());

        driver.close();
        driver.quit();
    }
}