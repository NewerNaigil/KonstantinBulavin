package ru.training.at.hw5.steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

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

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectVipCheckbox() {
        userTablePage.getListCheckbox().stream()
                     .filter(x -> x.getAttribute("id").equals("ivan"))
                     .forEach(WebElement::click);
    }
}
