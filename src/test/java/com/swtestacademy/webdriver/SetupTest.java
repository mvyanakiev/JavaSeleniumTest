package com.swtestacademy.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupTest {

    public static String checkOs(){
        String osType = "unknown";
        String type = System.getProperty("os.name").toLowerCase();

        if (type.startsWith("win")) {
            osType = "windows";
        } else if (type.startsWith("mac")) {
            osType = "mac";
        }

        return osType;
    }

    public static WebDriver setupDriver() {
        WebDriver driver;

        if ("windows".equals(checkOs())) {
            System.setProperty("webdriver.chrome.driver", ConstantsTests.CHROMEDRIVER_PATH);
        }
        return new ChromeDriver();
    }
}
