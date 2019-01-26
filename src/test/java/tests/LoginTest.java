package tests;

import org.junit.Test;
import pages.HomePage;

public class LoginTest extends BaseTest {
    @Test
    public void InvalidLoginTest_InvalidUserNameInvalidPassword(){

        HomePage homePage = new HomePage(driver);

        homePage
                .goToN11()
                .goToLoginPage()
                .logInToN11("tralala@gmail.com", "123456")
                .verifyErrorMessage2("E-posta adresiniz veya şifreniz hatalı");
    }

    @Test
    public void InvalidLoginTest_EmptyUserEmptyPassword(){

        HomePage homePage = new HomePage(driver);

        homePage
                .goToN11()
                .goToLoginPage()
                .logInToN11("", "")
                .verifyErrorMessage1("Lütfen e-posta adresinizi girin.")
                .verifyErrorMessage2("Bu alanın doldurulması zorunludur.");
    }
}
