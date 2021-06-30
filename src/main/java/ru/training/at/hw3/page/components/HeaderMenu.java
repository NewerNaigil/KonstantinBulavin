package ru.training.at.hw3.page.components;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent {

    @FindBy(linkText = "Home")
    private WebElement home;
    @FindBy(linkText = "Contact form")
    private WebElement contactForm;
    @FindBy(linkText = "Service")
    private WebElement service;
    @FindBy(linkText = "Metals & Colors")
    private WebElement metalAndColors;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public Set<String> getSetOfTextHeadMenuItem() {
        return Set.of(home.getText(), contactForm.getText(), service.getText(), metalAndColors.getText());
    }
}
