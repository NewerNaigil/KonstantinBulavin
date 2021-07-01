package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.page.DifferentElementsPage;
import ru.training.at.hw4.page.HomePage;

public class AbstractStep {

    HomePage homePage;
    DifferentElementsPage differentElementsPage;

    public AbstractStep(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }
}
