package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlertExampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void setupTest() {
        driver = SetupTest.setupDriver();
    }

    @Test
    public void AlertExampleTest() {
        driver.navigate().to("http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
        if (ConstantsTests.OS_WINDOWS.equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");

        WebElement alertButton = driver.findElement(By.cssSelector("body > button"));
        alertButton.click();
        String expectedAlertMessage = "I am an alert box!";

        //Captured Alert Text (Actual Text)
        String actualAlertMessage = driver.switchTo().alert().getText();

        assertThat(expectedAlertMessage, is(actualAlertMessage));

        //Accept the alert (Click OK)
        driver.switchTo().alert().accept();
    }


    @Test
    public void ConfirmExampleTest() {
        driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        if (ConstantsTests.OS_WINDOWS.equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");

        WebElement tryItButton = driver.findElement(By.cssSelector("body > button"));
        tryItButton.click();

        driver.switchTo().alert().accept();
        WebElement actualMessage = driver.findElement(By.cssSelector("#demo"));
        assertThat(actualMessage.getText(), is("You pressed OK!"));

        tryItButton.click();
        driver.switchTo().alert().dismiss();
        assertThat(actualMessage.getText(), is("You pressed Cancel!"));
    }

    @Test
    public void PromptExampleTest() {
        driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        if (ConstantsTests.OS_WINDOWS.equals(SetupTest.checkOs()))
            driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");

        WebElement tryItButton = driver.findElement(By.cssSelector("body > button"));
        WebElement actualMessage = driver.findElement(By.cssSelector("#demo"));
        tryItButton.click();
        driver.switchTo().alert().sendKeys("ASD");
        driver.switchTo().alert().accept();

        assertThat("Hello ASD! How are you today?", is(actualMessage.getText()));
    }


    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
