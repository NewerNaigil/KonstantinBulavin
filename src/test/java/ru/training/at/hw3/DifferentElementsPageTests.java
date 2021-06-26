package ru.training.at.hw3;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DifferentElementsPageTests extends AbstractTest {

    @Test(groups = Tags.HW3)
    public void differentElementsPageTest() {

        // 1. Open test site by URL
        homePage.openPage();

        // 2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");

        // 3. Perform login
        homePage.login();

        // 4. Assert User name in the left-top side of screen that user is loggined.
        Assert.assertTrue(homePage.getLoginForm().getUserNameElement().isDisplayed());
        Assert.assertEquals(homePage.getLoginForm().getUserNameElement().getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        homePage.getLeftSideMenu().clickToDifferentElements();

        // 6. Select checkboxes
        differentElementsPage.selectCheckbox("Water");
        differentElementsPage.selectCheckbox("Wind");

        // 7. Select radio
        differentElementsPage.selectRadioButton("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectDropdownMenu("Yellow");

        // 9. Assert checkboxes, radio and dropdown menu.
        differentElementsPage.compareLogRows(ProperTestData.LOGS);
    }

    // 10. Close Browser
    // Browser will close in BaseTest
}
