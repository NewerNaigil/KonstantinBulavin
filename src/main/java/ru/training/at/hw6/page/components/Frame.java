package ru.training.at.hw6.page.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends AbstractComponent {

    @FindBy(id = "frame-button")
    private List<WebElement> frameButtonList;

    public Frame(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getFrameButtonList() {
        return frameButtonList;
    }

    public void returnToHomePage() {
        webDriver.switchTo().defaultContent();
    }
}
