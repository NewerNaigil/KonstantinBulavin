package ru.training.at.hw5.steps;

import io.cucumber.java.en.When;

public class WhenSteps extends AbstractStep {

    @When("I select {string} checkbox on main content area")
    public void selectCheckbox(String checkboxText) {
        differentElementsPage.selectCheckbox(checkboxText);
    }

    @When("I select {string} radio button on main content area")
    public void selectRadioButton(String radioText) {
        differentElementsPage.selectRadioButton(radioText);
    }

    @When("I select {string} in dropdown menu on main content area")
    public void selectDropdownMenu(String dropdownMenuText) {
        differentElementsPage.selectDropdownMenu(dropdownMenuText);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckbox(String userName) {
        //userTablePage.selectCheckbox(userName);
    }

    //    When I select 'vip' checkbox for "Sergey Ivan"
    //    Then 1 log row has "Vip: condition changed to true" text in log section
}
