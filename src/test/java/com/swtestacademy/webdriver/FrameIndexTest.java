package com.swtestacademy.webdriver;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameIndexTest {

    static WebDriver driver;
    static Boolean osWin = false;

    @BeforeClass
    public static void setupTest() {

        if (System.getProperty("os.name").startsWith("Win")) {
            osWin = true;
        }

        if (osWin)
            System.setProperty("webdriver.chrome.driver", ConstantsTests.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
    }

    //todo
    // https://www.swtestacademy.com/selenium-webdriver-frames/


}
