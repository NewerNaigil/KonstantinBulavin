package ru.training.at.hw3.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw3.ConfigFileReader;

public class BaseTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void prepareTestData() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void shutdownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
