package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WindowHandlesTest {

    static WebDriver driver;
    private String testUrl = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target";

    @BeforeClass
    public static void setupTest() {
        driver = SetupTest.setupDriver();
    }

    @Test
    public void WindowHandleTest() {
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        System.out.println("Current window handle: " + driver.getWindowHandle());

        driver.switchTo().frame("iframeResult");
        WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        visitLink.click();

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        System.out.println("Total window number: " + windowHandlesList.size());

        driver.switchTo().window(windowHandlesList.get(1));
        System.out.println("Current window handle: " + driver.getWindowHandle());

        WebElement expectedText = driver.findElement(By.className("w3-right"));

//fixme
//        assertThat("THE WORLD'S LARGEST WEB DEVELOPER SITE", is(expectedText.getText()));
        System.out.println("hoi: " + expectedText.getText());

        driver.switchTo().window(windowHandlesList.get(0));
//        System.out.println("Current window handle: " + driver.getWindowHandle() + System.lineSeparator());

//        driver.switchTo().window(windowHandlesList.get(1));
//        WebElement setResultButton = driver.findElement(By.xpath("/html//div[@class='w3-bar']/button[.='Run »']"));
//        System.out.println(setResultButton.getText());


    }


//todo
// https://www.swtestacademy.com/selenium-webdriver-windows/


    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
