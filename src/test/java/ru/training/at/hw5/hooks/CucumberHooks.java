package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.training.at.hw5.driver.WebDriverSingleton;
import ru.training.at.hw5.testdata.ConfigFileReader;

public class CucumberHooks {

    @Before
    public void initDriver() {
        WebDriverSingleton.getDriver();
    }

    @After
    public void closeDriver() {
        WebDriverSingleton.closeDriver();
    }

    //    @Before
    //    public void prepareTestData() {
    //        WebDriverSingleton.getDriver();
    //    }
    //
    //
    //    @After
    //    public void shutdownDriver() {
    //        WebDriverSingleton.shutdownDriver();
    //    }
}
