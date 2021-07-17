package ru.training.at.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw7.config.ConfigFileReader;
import ru.training.at.hw7.entities.User;

public class JdiAbstractTest {

    ConfigFileReader configFileReader;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        PageFactory.initSite(JdiSite.class);
        JdiSite.open();
        JdiSite.login(User.ROMAN);

        configFileReader = new ConfigFileReader();
        configFileReader.loadProperty();
        context.setAttribute("jsonPath", configFileReader.getJsonPath());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
