package ru.training.at.hw4.page.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractComponent {

    @FindBy(css = "li[class = 'dropdown uui-profile-menu']")
    private WebElement dropdownProfileMenu;
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
        dropdownProfileMenu.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public WebElement getUserNameElement() {
        return userNameElement;
    }
}
