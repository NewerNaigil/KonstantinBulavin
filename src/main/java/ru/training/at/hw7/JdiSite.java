package ru.training.at.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw7.entities.User;
import ru.training.at.hw7.page.JdiHomePage;
import ru.training.at.hw7.page.JdiMetalAndColorsPage;
import ru.training.at.hw7.section.HeaderSection;
import ru.training.at.hw7.section.RightSideResultSection;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html") @Title("Home Page")
    public static JdiHomePage jdiHomePage;
    @Url("metals-colors.html") @Title("Metal and Colors")
    public static JdiMetalAndColorsPage metalAndColorsPage;

    public static HeaderSection headerSection;


    public static void open() {
        jdiHomePage.open();
    }

    public static void login(User user) {
        jdiHomePage.login(user);
    }

}
