package ru.training.at.hw3.page.components;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent {

    @FindBy(xpath = "//a[contains(text(), 'Home') "
        + "or contains(text(), 'Contact form') "
        + "or contains(text(), 'Service') "
        + "or contains(text(), 'Metals & Colors')]")
    private List<WebElement> headMenuItems;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public Set<String> getSetOfTextHeadMenuItem() {
        Set<String> setOfText = new HashSet<>();
        for (WebElement webElement : headMenuItems) {
            setOfText.add(webElement.getText());
        }
        return setOfText;
    }
}
