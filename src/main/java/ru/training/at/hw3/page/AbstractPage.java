package ru.training.at.hw3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.ConfigFileReader;

public class AbstractPage {

    WebDriver webDriver;
    ConfigFileReader configFileReader;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        configFileReader = new ConfigFileReader();
        configFileReader.loadProperty();
    }
}
