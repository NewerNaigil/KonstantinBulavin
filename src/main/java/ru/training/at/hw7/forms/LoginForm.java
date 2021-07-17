package ru.training.at.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw7.entities.User;

public class LoginForm extends Form<User> {

    @UI("#name")
    private TextField name;
    @UI("#password")
    private TextField password;
    @UI("#login-button")
    private Button submit;
}
