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

    @Step("Open through the header menu Service -> Different Elements Page")
    public void goToDifferentElementsPageThroughLeftSideMenu() {
        homePage.getHeaderMenu().clickToDifferentElements();
    }

    @Step("Select checkbox: '{checkboxText}'")
    public void selectCheckbox(String checkboxText) {
        differentElementsPage.selectCheckbox(checkboxText);
    }

    @Step("Select radio button: '{radioText}'")
    public void selectRadioButton(String radioText) {
        differentElementsPage.selectRadioButton(radioText);
    }

    @Step("Select in dropdown: '{dropdownText}'")
    public void selectInDropdownMenu(String dropdownText) {
        differentElementsPage.selectDropdownMenu(dropdownText);
    }
}
