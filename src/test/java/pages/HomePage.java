package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseUrl = "http://www.n11.com/";
    By signInButtonBy = By.className("btnSignIn");


    public HomePage goToN11() {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage goToLoginPage() {
        click(signInButtonBy);
        return new LoginPage(driver);
    }


}
