package com.swtestacademy.webdriver;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class Manipulation {
    static WebDriver driver;
    final private String URL = "http://www.practiceselenium.com/practice-form.html";

    @BeforeClass
    public static void setupTest() {
        System.setProperty("webdriver.chrome.driver", ConstantsTests.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Before
    public void navigateToWebPage() {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void T01_radioButtons() {

        WebElement maleRadioButton = driver.findElement(By.id("sex-0"));
        WebElement femaleRadioButton = driver.findElement(By.id("sex-1"));

        femaleRadioButton.click();
        assertTrue("Female radio button is not displayed!", femaleRadioButton.isDisplayed());
        assertTrue("Female radio button is not enabled!", femaleRadioButton.isEnabled());
        assertTrue("Female radio button is not selected!", femaleRadioButton.isSelected());

        maleRadioButton.click();
        assertTrue("Male radio button is not displayed!", maleRadioButton.isDisplayed());
        assertTrue("Male radio button is not enabled!", maleRadioButton.isEnabled());
        assertTrue("Male radio button is not selected!", maleRadioButton.isSelected());
    }

    @Test
    public void T02_checkBoxTest() {

        WebElement checkBoxRedTea = driver.findElement(By.id("tea2"));

        assertTrue("Check box is not displayed!", checkBoxRedTea.isDisplayed());
        assertTrue("Check box is not enabled!", checkBoxRedTea.isEnabled());
        assertFalse("Check box is selected!", checkBoxRedTea.isSelected()); // FALSE

        checkBoxRedTea.click();

        assertTrue("Check box is not displayed!", checkBoxRedTea.isDisplayed());
        assertTrue("Check box is not enabled!", checkBoxRedTea.isEnabled());
        assertTrue("Check box is not selected!", checkBoxRedTea.isSelected());
    }

    @Test
    public void T03_dropDownTest() {

        WebElement dropDownOption = driver.findElement(By.id("continents"));
        Select countrySelect = new Select(dropDownOption);
//        countrySelect.selectByValue("Europe"); // няма Value в този сайт
        countrySelect.selectByIndex(1);
//        countrySelect.selectByVisibleText("Europe");
        dropDownOption.click();
        dropDownOption.click();
        assertThat("Europe is not selected", countrySelect.getFirstSelectedOption().getText(), is("Europe"));
    }

    @Test
    public void T04_MultiSelectTest() throws InterruptedException {

        WebElement multiSelect = driver.findElement(By.id("selenium_commands"));
        List<WebElement> multiSelectOptions = multiSelect.findElements(By.tagName("option"));

        multiSelectOptions.get(0).click();
        multiSelectOptions.get(2).click();

        Thread.sleep(2000);

        assertThat("Selected option is not Browser Commands", multiSelectOptions.get(0).getText(), is("Browser Commands"));
        assertThat("Selected option is not Switch Commands", multiSelectOptions.get(2).getText(), is("Switch Commands"));
    }

    @Test
    public void T05_MultiSelectTestSelectMethod() throws InterruptedException {

        WebElement multiSelect = driver.findElement(By.id("selenium_commands"));
        Select teaSelect = new Select(multiSelect);

        teaSelect.selectByVisibleText("Navigation Commands");
        teaSelect.selectByVisibleText("WebElement Commands");
        Thread.sleep(1000);

        teaSelect.deselectAll();

        teaSelect.selectByVisibleText("Browser Commands");
        teaSelect.selectByVisibleText("Switch Commands");
        Thread.sleep(1000);

        List<WebElement> selectedTea = teaSelect.getAllSelectedOptions();
        assertThat("Selected option is not Browser Commands", selectedTea.get(0).getText(), is("Browser Commands"));
        assertThat("Selected option is not Switch Commands", selectedTea.get(1).getText(), is("Switch Commands"));
    }

    @Test
    public void T06_submitWithForm() throws InterruptedException {

        WebElement chaiForm = driver.findElement(By.className("form-horizontal"));
        chaiForm.submit();
        Thread.sleep(1000);
        driver.navigate().back();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(1000);
        driver.navigate().back();
//        submit.sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
