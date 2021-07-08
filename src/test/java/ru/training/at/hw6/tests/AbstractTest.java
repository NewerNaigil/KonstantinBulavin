package ru.training.at.hw6.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw6.ConfigFileReader;
import ru.training.at.hw6.Tags;
import ru.training.at.hw6.driver.WebDriverSingleton;
import ru.training.at.hw6.steps.ActionStep;
import ru.training.at.hw6.steps.AssertionStep;

public class AbstractTest {

    WebDriver webDriver;
    ActionStep actionStep;
    AssertionStep assertionStep;
    ConfigFileReader configFileReader;


    @BeforeClass(groups = Tags.HW6)
    public void prepareTestData() {
        webDriver = WebDriverSingleton.getDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @BeforeMethod(groups = Tags.HW6)
    public void prepareTest(ITestContext testContext) {
        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);
        configFileReader = new ConfigFileReader();
        configFileReader.loadProperty();
        testContext.setAttribute("webDriver", webDriver);
    }

    @AfterClass(groups = Tags.HW6)
    public void shutdownDriver() {
        WebDriverSingleton.closeDriver();
    }
}
