package com.swtestacademy.webdriver;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class DriverLevelInterrogationTest {
    static WebDriver driver;
    final private String URL = "https://www.teknosa.com/";

    @BeforeClass
    public static void setupTest() {
        System.setProperty("webdriver.chrome.driver", ConstantsTests.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Before
    public void navigateToWebPage() {
        driver.navigate().to(URL);
    }

    //get title
    @Test
    public void T01_getTitle() {
        assertThat(driver.getTitle(), is("Teknosa | Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji"));
    }

    @Test
    public void T02_getUrl() {
        assertThat(driver.getCurrentUrl(), is(URL));
    }

    // get page source
    @Test
    public void T03_getPageSource() {
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Teknosa"));
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
