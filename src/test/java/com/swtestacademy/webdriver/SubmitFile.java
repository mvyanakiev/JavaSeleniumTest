package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.URISyntaxException;

import static junit.framework.TestCase.assertTrue;

public class SubmitFile {
    static WebDriver driver;

    @BeforeClass
    public static void setupTest() {
        driver = SetupTest.setupDriver();
    }

    @Before
    public void navigateToWebPage() {
        driver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");

        if ("windows".equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
    }

    @Test
    public void SubmitFileTest() throws URISyntaxException {
        driver.switchTo().frame("iframeResult");

        //Find the elements
        WebElement browseButton = driver.findElement(By.cssSelector("body > form:nth-child(3) > input[type=\"file\"]:nth-child(1)"));
        WebElement submitButton = driver.findElement(By.cssSelector("body > form:nth-child(3) > input[type=\"submit\"]:nth-child(4)"));

        //Test file deceleration
        File testFile = null;

        if ("windows".equals(SetupTest.checkOs())) {
            testFile = new File("C:\\Users\\milko.yanakiev\\Documents\\code\\firstSeleniumTest\\src\\main\\resources\\test_file.txt");
        } else if ("mac".equals(SetupTest.checkOs())) {
            // todo -> If os is Mac change path to file
            testFile = new File("C:\\Users\\milko.yanakiev\\Documents\\code\\firstSeleniumTest\\src\\main\\resources\\test_file.txt");
        }


        //Select test file
        browseButton.sendKeys(testFile.getAbsolutePath());


        //Click submit button
        submitButton.click();

        //Check the result
        WebElement resultText = driver.findElement(By.cssSelector("body > div.w3-container.w3-large.w3-border"));
        System.out.println("resulttext: " + resultText.getText());
        assertTrue("test_file.txt is not submitted!", resultText.getText().contains("test_file"));
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
