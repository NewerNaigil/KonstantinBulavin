package ru.training.at.hw6.steps;

import io.qameta.allure.Step;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw6.ProperTestData;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String expectedTitle) {
        Assert.assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @Step("Assert Username is loggined")
    public void usernameIsLoggined() {
        Assert.assertTrue(homePage.getLoginForm().getUserNameElement().isDisplayed());
        Assert.assertEquals(homePage.getLoginForm().getUserNameElement().getText(), "ROMAN IOVLEV");
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void headerItemsDisplayedAndHaveProperTexts() {
        Assert.assertEquals(homePage.getHeaderMenu().getSetOfTextHeadMenuItem(),
            ProperTestData.HEADER_SELECTOR_ITEMS_SET);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void fourImagesOnIndexPage() {
        Assert.assertEquals(homePage.getListOfImage().size(), 4);
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void textsUnderIconsHaveProperText() {
        Set<String> reSet = homePage.getTextUnderIcon().stream()
                                    .map(WebElement::getText)
                                    .collect(Collectors.toSet());

        Assert.assertEquals(reSet, ProperTestData.TEXT_UNDER_ICON_SET);
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void iframeWithFrameButtonExist() {
        Assert.assertTrue(homePage.getListOfFrameWithButton().size() > 0);
    }

    @Step("Check that there is “Frame Button” in the iframe")
    public void frameButtonInIframeExist() {
        homePage.switchToFrame("frame");
        Assert.assertTrue(homePage.getFrame().getFrameButtonList().size() > 0);
        homePage.getFrame().returnToHomePage();
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void fiveItemsInLeftSectionDisplayedAndHaveProperText() {
        for (WebElement webElement : homePage.getLeftSideMenu().getSetLeftSideMenuItems()) {
            Assert.assertTrue(webElement.isDisplayed());
        }

        Assert.assertEquals(homePage.getLeftSideMenu().getSetLeftSideMenuItemText(),
            ProperTestData.TEXT_LEFT_SECTION_SET);
    }

    @Step("Assert checkboxes, radio and dropdown menu.")
    public void logsHaveProperText(Set<String> logsSet) {
        Assert.assertEquals(differentElementsPage.getLogRows(), logsSet);
    }
}
