package ru.training.at.hw3.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.ProperTestData;
import ru.training.at.hw3.page.DifferentElementsPage;
import ru.training.at.hw3.page.HomePage;

public class DifferentElementsPageTest extends BaseTest {

    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;


    @Test
    public void differentElementsPageTest() {

        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);

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

        for (WebElement webElement : differentElementsPage.getRightSideLogForm().getLogsList()) {
            boolean marker = false;
            for (String expected : ProperTestData.LOGS) {
                if (webElement.getText().contains(expected)) {
                    marker = true;
                }
            }
            Assert.assertTrue(marker);
        }

        // 10. Close Browser
        // Browser will close in BaseTest

    }
}
