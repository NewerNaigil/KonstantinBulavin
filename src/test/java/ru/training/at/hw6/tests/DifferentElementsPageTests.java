package ru.training.at.hw6.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw6.ProperTestData;
import ru.training.at.hw6.Tags;

public class DifferentElementsPageTests extends AbstractTest {

    @Feature(value = "Test UI interface")
    @Story(value = "Successful tests")
    @Test(groups = Tags.HW6)
    public void differentElementsPageTest() {

        // 1. Open test site by URL
        actionStep.openHomePage();

        // 2. Assert Browser title
        assertionStep.assertBrowserTitle("Home Page");

        // 3. Perform login
        actionStep.login(configFileReader.getLogin(), configFileReader.getPassword());

        // 4. Assert User name in the right-top side of screen that user is loggined.
        assertionStep.usernameIsLoggined();

        // 5. Open through the header menu Service -> Different Elements Page
        actionStep.goToDifferentElementsPageThroughLeftSideMenu();

        // 6. Select checkboxes
        actionStep.selectCheckbox("Water");
        actionStep.selectCheckbox("Wind");

        // 7. Select radio
        actionStep.selectRadioButton("Selen");

        // 8. Select in dropdown
        actionStep.selectInDropdownMenu("Yellow");

        // 9. Assert checkboxes, radio and dropdown menu.
        assertionStep.logsHaveProperText(ProperTestData.LOGS);

        // 10. Close Browser
        // Browser will close in BaseTest
    }
}
