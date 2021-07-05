package ru.training.at.hw5.page.components;

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
    @FindBy(css = "a[href = 'user-table.html']")
    private WebElement userTable;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public Set<String> getSetOfTextHeadMenuItem() {
        return Set.of(home.getText(), contactForm.getText(), service.getText(), metalAndColors.getText());
    }

    public void clickToService() {
        service.click();
    }

    public void clickToDifferentElements() {
        differentElements.click();
    }

    public void clickToUserTable() {
        userTable.click();
    }

    public void clickToDifferentElementsInService() {
        service.click();
        differentElements.click();
    }
}
