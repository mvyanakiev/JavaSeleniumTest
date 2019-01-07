package com.swtestacademy.webdriver;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupTest {

    public WebDriver driver;
    public boolean osWin = false;
    public String osType;

//    public static boolean checkOs(){
//        Boolean osWin = null;
//
//        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
//            osWin = true;
//        }
//        return osWin;
//    }


    public static String checkOs(){
        String osType = "unknown";
        String type = System.getProperty("os.name").toLowerCase();

        if (type.startsWith("win")) {
            osType = "windows";
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
