package ru.training.at.hw3;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends AbstractTest {

    @Test(groups = Tags.HW3)
    public void homePageTest() {

        // 1. Open test site by URL
        homePage.openPage();

        // 2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");

        // 3. Perform login
        homePage.login();

        // 4. Assert Username is loggined
        Assert.assertEquals(homePage.getLoginForm().getUserNameElement().getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        Assert.assertEquals(homePage.getHeaderMenu().getSetOfTextHeadMenuItem(),
            ProperTestData.HEADER_SELECTOR_ITEMS_SET);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        Assert.assertEquals(homePage.getListOfImage().size(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        for (WebElement webElement : homePage.getTextUnderIcon()) {
            Assert.assertTrue(ProperTestData.TEXT_UNDER_ICON_SET.contains(webElement.getText()));
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        Assert.assertTrue(homePage.getListOfFrameWithButton().size() > 0);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrame("frame");
        Assert.assertTrue(homePage.getFrame().getFrameButtonList().size() > 0);

        // 10. Switch to original window back
        homePage.getFrame().returnToHomePage();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        for (WebElement webElement : homePage.getLeftSideMenu().getLeftSideMenuItems()) {
            Assert.assertTrue(webElement.isDisplayed());
        }

        Assert.assertEquals(homePage.getLeftSideMenu().getSetLeftSideMenuItemText(),
            ProperTestData.TEXT_LEFT_SECTION_SET);

        // 12. Close Browser
        // Browser will close in BaseTest
    }
}
