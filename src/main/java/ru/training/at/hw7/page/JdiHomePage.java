package ru.training.at.hw7.page;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw7.entities.User;
import ru.training.at.hw7.forms.LoginForm;

public class JdiHomePage extends WebPage {

    @FindBy(id = "user-name")
    private Label userName;

    @FindBy(id = "user-icon")
    private Icon userIcon;

    public LoginForm loginForm;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
        userName.is().displayed();
    }
}
