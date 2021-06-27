package ru.training.at.hw4.page.components;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenu extends AbstractComponent {

    @FindBy(css = "ul[class = 'sidebar-menu left'] > li")
    private List<WebElement> leftSideMenuItems;
    @FindBy(className = "menu-title")
    private WebElement serviceMenu;
    @FindBy(css = "ul[class='sidebar-menu left'] a[href='different-elements.html']")
    private WebElement differentElementLink;

    public LeftSideMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getLeftSideMenuItems() {
        return leftSideMenuItems;
    }

    public Set<String> getSetLeftSideMenuItemText() {
        return leftSideMenuItems.stream()
                                .map(WebElement::getText)
                                .collect(Collectors.toSet());
    }

    public void clickToDifferentElements() {
        serviceMenu.click();
        differentElementLink.click();
    }
}
