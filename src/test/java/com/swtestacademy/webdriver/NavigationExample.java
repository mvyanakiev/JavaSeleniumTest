package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;


import static org.hamcrest.MatcherAssert.assertThat;

public class NavigationExample {

    static WebDriver driver;
    final private String URL1 = "http://www.teknosa.com";
    final private String URL2 = "http://www.amazon.com";

    @BeforeClass
    public static void setupTest(){
        System.setProperty("webdriver.chrome.driver", ConstantsTests.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Test
    public void T01_getURLExample() {
        //Go to www.teknosa.com
        driver.get(URL1);

        //Check title is correct
        Assert.assertEquals("Teknosa | Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji", driver.getTitle());
    }

    @Test
    public void T02_getURLExample() {
        //Go to www.amazon.com
        driver.navigate().to(URL2);

        //Check title is correct
        Assert.assertEquals("Title check failed!","Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    @Test
    public void T03_backForwardRefreshExample() {

        driver.get(URL1);
        Assert.assertEquals("Teknosa | Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji", driver.getTitle());
        driver.navigate().to(URL2);
        Assert.assertEquals("Title check failed!","Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
        driver.navigate().back();
        Assert.assertEquals("Teknosa | Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji", driver.getTitle());
        driver.navigate().forward();
        driver.navigate().refresh();
        assertThat(driver.getTitle(), is("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
    }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }



}
