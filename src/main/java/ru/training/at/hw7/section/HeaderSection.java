package ru.training.at.hw7.section;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class HeaderSection extends Section {

    @UI(".uui-header a[href = 'metals-colors.html']")
    public Button metalAndColors;
}
