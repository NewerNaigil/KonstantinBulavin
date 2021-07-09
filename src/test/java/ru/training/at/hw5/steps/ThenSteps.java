package ru.training.at.hw5.steps;

import com.google.common.collect.Table;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.messages.Messages.GherkinDocument.Feature.TableRow.TableCell;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.testdata.ProperTestData;

public class ThenSteps extends AbstractStep {

    @Then("1 log row has {string} text in log section")
    public void logRowShouldContainsProperTextInLogSelection(String logRow) {
        Assert.assertTrue(ProperTestData.LOGS.contains(logRow));
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void sixNumberTypeDropdownsShouldBeDisplayedOnUsersTable() {
        userTablePage.getListNumbers().stream()
                     .map(WebElement::isDisplayed)
                     .forEach(Assert::assertTrue);

        userTablePage.getListType().stream()
                     .map(WebElement::isDisplayed)
                     .forEach(Assert::assertTrue);

        Assert.assertEquals(userTablePage.getListNumbers().size(), 6);
        Assert.assertEquals(userTablePage.getListType().size(), 6);
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void sixUsernamesShouldBeDisplayedOnUsersTable() {
        userTablePage.getListUsername().stream()
                     .map(WebElement::isDisplayed)
                     .forEach(Assert::assertTrue);

        Assert.assertEquals(userTablePage.getListUsername().size(), 6);
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void sixDescriptionTextsUnderImagesShouldBeDisplayed() {
        userTablePage.getListDescription().stream()
                     .map(WebElement::isDisplayed)
                     .forEach(Assert::assertTrue);

        Assert.assertEquals(userTablePage.getListDescription().size(), 6);
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void sixCheckboxesShouldBeDisplayedOnUsersTable() {
        userTablePage.getListCheckbox().stream()
                     .map(WebElement::isDisplayed)
                     .forEach(Assert::assertTrue);

        Assert.assertEquals(userTablePage.getListCheckbox().size(), 6);
    }

    @Then("{string} page should be opened")
    public void userTablePageShouldBeOpened(String expectedTitle) {
        Assert.assertEquals(userTablePage.getPageTitle(), expectedTitle);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainValues(DataTable table) {
        List<List<String>> actual = table.asLists(String.class);
        List<List<String>> expected = userTablePage.getTextTable();

        Assert.assertEquals(actual, expected);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dropdownValues) {
        Assert.assertEquals(dropdownValues.asList(), userTablePage.getTextDropdownOptions());
    }
}
