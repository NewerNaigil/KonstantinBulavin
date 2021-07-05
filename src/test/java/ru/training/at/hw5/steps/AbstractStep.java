package ru.training.at.hw5.steps;

import ru.training.at.hw5.driver.WebDriverSingleton;
import ru.training.at.hw5.page.DifferentElementsPage;
import ru.training.at.hw5.page.HomePage;
import ru.training.at.hw5.page.UserTablePage;
import ru.training.at.hw5.testdata.ConfigFileReader;

public class AbstractStep {

    HomePage homePage;
    DifferentElementsPage differentElementsPage;
    ConfigFileReader configFileReader;
    UserTablePage userTablePage;

    public AbstractStep() {
        homePage = new HomePage(WebDriverSingleton.getDriver());
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.getDriver());
        userTablePage = new UserTablePage(WebDriverSingleton.getDriver());
        configFileReader = new ConfigFileReader();
        configFileReader.loadProperty();
    }
}
