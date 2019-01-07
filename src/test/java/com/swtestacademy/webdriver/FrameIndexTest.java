package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class FrameIndexTest {

    static WebDriver driver;
    private final String testUrl = "http://www.londonfreelance.org/courses/frames/index.html";

    @BeforeClass
    public static void setupTest() {
       driver = SetupTest.setupDriver();
    }

    @Test
    public void T01_byIndex(){
        if ("windows".equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
        driver.navigate().to(testUrl);

        driver.switchTo().frame(2);
        WebElement h2tag = driver.findElement(By.cssSelector("body > h2"));
        assertThat("Title bar (top.html)", is(h2tag.getText()));
    }

    @Test
    public void T02_byName(){
        if ("windows".equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
        driver.navigate().to(testUrl);

        driver.switchTo().frame("main");
        WebElement h2tag = driver.findElement(By.cssSelector("body > h2"));
        assertThat("Title bar (top.html)", is(h2tag.getText()));
    }

    @Test
    public void T03_byCss(){
        if ("windows".equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
        driver.navigate().to(testUrl);

        WebElement mainFrame = driver.findElement(By.cssSelector("html > frameset > frameset > frameset > frame:nth-child(1)"));
        driver.switchTo().frame(mainFrame);

        WebElement h2tag = driver.findElement(By.cssSelector("body > h2"));
        assertThat("Title bar (top.html)", is(h2tag.getText()));
    }

    @Test
    public void T04_defaultContent(){
        if ("windows".equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
        driver.navigate().to(testUrl);

        driver.switchTo().frame("main");
        WebElement h2tag = driver.findElement(By.cssSelector("body > h2"));
        assertThat("Title bar (top.html)", is(h2tag.getText()));

        driver.switchTo().defaultContent();
        assertThat("Sample frames page", is(driver.getTitle()));
    }


    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
