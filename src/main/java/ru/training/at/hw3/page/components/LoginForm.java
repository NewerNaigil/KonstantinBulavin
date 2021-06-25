package ru.training.at.hw3.page.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractComponent {

    @FindBy(css = "li[class = 'dropdown uui-profile-menu']")
    private WebElement dropdownToggleCaret;
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userNameElement;

    public LoginForm(WebDriver webDriver) {
        super(webDriver);
    }

    public void login(String name, String password) {
        dropdownToggleCaret.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public WebElement getUserNameElement() {
        return userNameElement;
    }
}
