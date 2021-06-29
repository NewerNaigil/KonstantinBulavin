package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open Home Page")
    public void openHomePage() {
        homePage.openPage();
    }

    @Step("Enter Login: '{login}' and Password: '{password}'")
    public void login(String login, String password) {
        homePage.login(login, password);
    }

    @Step
    public void goToDifferentElementsPageThroughLeftSideMenu() {
        homePage.getLeftSideMenu().clickToDifferentElements();
    }

    @Step
    public void selectCheckbox(String checkboxText) {
        differentElementsPage.selectCheckbox(checkboxText);
    }

    @Step
    public void selectRadioButton(String radioText) {
        differentElementsPage.selectRadioButton(radioText);
    }

    @Step
    public void selectInDropdownMenu(String dropdownText) {
        differentElementsPage.selectDropdownMenu(dropdownText);
    }
}
