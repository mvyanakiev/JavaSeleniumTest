package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class FrameIndexTest {

    static WebDriver driver;
    static Boolean osWin = false;
    private final String testUrl = "http://www.londonfreelance.org/courses/frames/index.html";

    @BeforeClass
    public static void setupTest() {

        if (System.getProperty("os.name").startsWith("Win")) {
            osWin = true;
        }

        if (osWin)
            System.setProperty("webdriver.chrome.driver", ConstantsTests.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Test
    public void T01_byIndex(){
        if(osWin)
            driver.manage().window().maximize();
        driver.navigate().to(testUrl);

        driver.switchTo().frame(2);
        WebElement h2tag = driver.findElement(By.cssSelector("body > h2"));
        assertThat("Title bar (top.html)", is(h2tag.getText()));
    }

    @Test
    public void T02_byName(){
        if(osWin)
            driver.manage().window().maximize();
        driver.navigate().to(testUrl);

        driver.switchTo().frame("main");
        WebElement h2tag = driver.findElement(By.cssSelector("body > h2"));
        assertThat("Title bar (top.html)", is(h2tag.getText()));
    }

    @Test
    public void T03_byCss(){
        if(osWin)
            driver.manage().window().maximize();
        driver.navigate().to(testUrl);

        WebElement mainFrame = driver.findElement(By.cssSelector("html > frameset > frameset > frameset > frame:nth-child(1)"));
        driver.switchTo().frame(mainFrame);

        WebElement h2tag = driver.findElement(By.cssSelector("body > h2"));
        assertThat("Title bar (top.html)", is(h2tag.getText()));
    }

    @Test
    public void T04_defaultContent(){
        if(osWin)
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
