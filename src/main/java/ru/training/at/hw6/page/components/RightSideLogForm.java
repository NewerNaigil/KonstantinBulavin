package ru.training.at.hw6.page.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightSideLogForm extends AbstractComponent {

    @FindBy(css = "ul[class='panel-body-list logs'] li")
    private List<WebElement> logsList;

    public RightSideLogForm(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }
}
