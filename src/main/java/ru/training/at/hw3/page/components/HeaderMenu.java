package ru.training.at.hw3.page.components;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent {

    @FindBy(css = "a[href = 'index.html']")
    private WebElement home;
    @FindBy(css = "a[href = 'contacts.html']")
    private WebElement contactForm;
    @FindBy(css = ".dropdown-toggle")
    private WebElement service;
    @FindBy(css = "a[href = 'metals-colors.html']")
    private WebElement metalAndColors;
    @FindBy(css = "a[href = 'different-elements.html']")
    private WebElement differentElements;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public Set<String> getSetOfTextHeadMenuItem() {
        return Set.of(home.getText(), contactForm.getText(), service.getText(), metalAndColors.getText());
    }

    public void clickToDifferentElements() {
        service.click();
        differentElements.click();
    }

    public WebElement getHome() {
        return home;
    }
}
