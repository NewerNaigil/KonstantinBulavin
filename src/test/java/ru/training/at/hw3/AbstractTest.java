package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw3.page.DifferentElementsPage;
import ru.training.at.hw3.page.HomePage;

public class AbstractTest {

    static WebDriver webDriver;
    static HomePage homePage;
    static DifferentElementsPage differentElementsPage;

    @BeforeClass(groups = Tags.HW3)
    public static void prepareTestData() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @BeforeMethod(groups = Tags.HW3)
    public static void prepareTest() {
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @AfterClass(groups = Tags.HW3)
    public static void shutdownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
