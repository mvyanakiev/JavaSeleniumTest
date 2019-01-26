package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userNameBy = By.id("email");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("loginButton");
    By errorMessageField1 = By.xpath("//form[@id='loginForm']/div[1]/div[@class='errorMessage']/div[@class='errorText']");
    By errorMessageField2 = By.xpath("//form[@id='loginForm']/div[2]/div[@class='errorMessage']/div[@class='errorText']");

    public LoginPage logInToN11(String username, String password){
        writeText(userNameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage verifyErrorMessage1(String expectedText){
        assertEquals(errorMessageField1, expectedText);
        return this;
    }

    public LoginPage verifyErrorMessage2(String expectedText){
        assertEquals(errorMessageField2, expectedText);
        return this;
    }

}
