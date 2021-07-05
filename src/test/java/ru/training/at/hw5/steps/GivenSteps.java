package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;

public class GivenSteps extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openJdiGithubHomePage() {
        homePage.openPage();
    }

    @Given("I login as user 'Roman Iovlev'")
    public void login() {
        homePage.login(configFileReader.getLogin(), configFileReader.getPassword());
    }

    @Given("I click on 'Service' button in Header")
    public void clickOnServiceInHeaderMenu() {
        homePage.getHeaderMenu().clickToService();
    }

    @Given("I click on 'Different Element' button in 'Service' dropdown")
    public void clickOnDifferentElementsInServiceDropdown() {
        homePage.getHeaderMenu().clickToDifferentElements();
    }

    @Given("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableInServiceDropdown() {
        homePage.getHeaderMenu().clickToUserTable();
        //userTablePage.createTable();
    }

    //    Given I open JDI GitHub site
    //    And I login as user "Roman Iovlev"
    //    And I click on "Service" button in Header
    //    And I click on 'Different Element' button in "Service" dropdown
}
