package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.Tags;
import ru.training.at.hw4.listeners.AllureListener;

//@Listeners(AllureListener.class)
public class FailedTest extends AbstractTest {

    @Feature(value = "Test UI interface")
    @Story(value = "Failed Test")
    @Test(groups = Tags.HW4)
    public void homePageTest() {

        // 1. Open test site by URL
        actionStep.openHomePage();

        // 3. Perform login
        actionStep.login("Vadim", "1234");

        // 4. Assert Username is loggined
        assertionStep.usernameIsLoggined();
        //
        //        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        //        assertionStep.headerItemsDisplayedAndHaveProperTexts();
        //
        //        // 6. Assert that there are 4 images on the Index Page and they are displayed
        //        assertionStep.fourImagesOnIndexPage();
        //
        //        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //        assertionStep.textsUnderIconsHaveProperText();
        //
        //        // 8. Assert that there is the iframe with “Frame Button” exist
        //        assertionStep.iframeWithFrameButtonExist();
        //
        //        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        //        // 10. Switch to original window back
        //        assertionStep.frameButtonInIframeExist();
        //
        //        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //        assertionStep.fiveItemsInLeftSectionDisplayedAndHaveProperText();
        //
        //        // 12. Close Browser
        //        // Browser will close in AbstractTest
    }
}
