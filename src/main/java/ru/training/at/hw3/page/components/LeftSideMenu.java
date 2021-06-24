package ru.training.at.hw3.page.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenu extends AbstractComponent {

    @FindBy(css = "ul[class = 'sidebar-menu left'] > li")
    private List<WebElement> lestSideMenuItems;

    public LeftSideMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getLestSideMenuItems() {
        return lestSideMenuItems;
    }
}
