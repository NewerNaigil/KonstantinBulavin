package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw4.ProperTestData;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void assertBrowserTitle(String expectedTitle) {
        Assert.assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @Step
    public void usernameIsLoggined() {
        Assert.assertTrue(homePage.getLoginForm().getUserNameElement().isDisplayed());
        Assert.assertEquals(homePage.getLoginForm().getUserNameElement().getText(), "ROMAN IOVLEV");
    }

    @Step
    public void headerItemsDisplayedAndHaveProperTexts() {
        Assert.assertEquals(homePage.getHeaderMenu().getSetOfTextHeadMenuItem(),
            ProperTestData.HEADER_SELECTOR_ITEMS_SET);
    }

    @Step
    public void fourImagesOnIndexPage() {
        Assert.assertEquals(homePage.getListOfImage().size(), 4);
    }

    @Step
    public void textsUnderIconsHaveProperText() {
        for (WebElement webElement : homePage.getTextUnderIcon()) {
            Assert.assertTrue(ru.training.at.hw3.ProperTestData.TEXT_UNDER_ICON_SET
                .contains(webElement.getText()));
        }
    }

    @Step
    public void iframeWithFrameButtonExist() {
        Assert.assertTrue(homePage.getListOfFrameWithButton().size() > 0);
    }

    @Step
    public void frameButtonInIframeExist() {
        homePage.switchToFrame("frame");
        Assert.assertTrue(homePage.getFrame().getFrameButtonList().size() > 0);
        homePage.getFrame().returnToHomePage();
    }

    @Step
    public void fiveItemsInLeftSectionDisplayedAndHaveProperText() {
        for (WebElement webElement : homePage.getLeftSideMenu().getLeftSideMenuItems()) {
            Assert.assertTrue(webElement.isDisplayed());
        }

        Assert.assertEquals(homePage.getLeftSideMenu().getSetLeftSideMenuItemText(),
            ProperTestData.TEXT_LEFT_SECTION_SET);
    }

    @Step
    public void logsHaveProperText(Set<String> logsSet) {
        differentElementsPage.compareLogRows(logsSet);
    }

    // 9. Assert checkboxes, radio and dropdown menu.
    //differentElementsPage.compareLogRows(ProperTestData.LOGS);
}
