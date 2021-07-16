package ru.training.at.hw7.section;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class HeaderSection extends Section {

    @UI("//ul[@ class = 'uui-navigation nav navbar-nav m-l8']/li/a")
    public Menu headMenu;


    public void met() {
    }
}
