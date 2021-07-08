package ru.training.at.hw6.page.components;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenu extends AbstractComponent {

    @FindBy(xpath = "//span[text() = 'Home']/..")
    private WebElement leftSideMenuHome;
    @FindBy(xpath = "//span[text() = 'Contact form']/..")
    private WebElement leftSideMenuContactForm;
    @FindBy(xpath = "//span[text() = 'Service']/..")
    private WebElement leftSideService;
    @FindBy(xpath = "//span[text() = 'Metals & Colors']/..")
    private WebElement leftSideMetalsAndColors;
    @FindBy(xpath = "//span[text() = 'Elements packs']/..")
    private WebElement leftSideElementsPacks;

    public LeftSideMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public Set<WebElement> getSetLeftSideMenuItems() {
        return Set.of(leftSideMenuHome,
            leftSideMenuContactForm,
            leftSideService,
            leftSideMetalsAndColors,
            leftSideElementsPacks);
    }

    public Set<String> getSetLeftSideMenuItemText() {
        return Set.of(leftSideMenuHome.getText(),
            leftSideMenuContactForm.getText(),
            leftSideService.getText(),
            leftSideMetalsAndColors.getText(),
            leftSideElementsPacks.getText());
    }
}
