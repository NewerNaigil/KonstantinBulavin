package ru.training.at.hw4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw4.ConfigFileReader;
import ru.training.at.hw4.Tags;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.AssertionStep;

public class AbstractTest {

    WebDriver webDriver;
    ActionStep actionStep;
    AssertionStep assertionStep;
    ConfigFileReader configFileReader;


    @BeforeClass(groups = Tags.HW4)
    public void prepareTestData() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @BeforeMethod(groups = Tags.HW4)
    public void prepareTest(ITestContext testContext) {
        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);
        configFileReader = new ConfigFileReader();
        configFileReader.loadProperty();
        testContext.setAttribute("webDriver", webDriver);
    }

    @AfterClass(groups = Tags.HW4)
    public void shutdownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
