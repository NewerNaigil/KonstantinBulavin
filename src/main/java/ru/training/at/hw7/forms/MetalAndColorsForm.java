package ru.training.at.hw7.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw7.entities.MetalAndColorsData;

public class MetalAndColorsForm extends Form<MetalAndColorsData> {

    @UI("input[type = 'radio']")
    private static RadioButtons summary;

    @UI(".vertical-group input")
    private static Checklist elements;

    @JDropdown(
        root = "div#colors",
        list = "div#colors li",
        expand = "div#colors .caret"
    )
    private static Dropdown colors;

    @JDropdown(root = "div#metals",
               list = "div#metals li",
               expand = "div#metals .caret"
    )
    private static Dropdown metals;

    @JDropdown(root = "#vegetables",
               list = "#vegetables li",
               expand = "#vegetables .caret")
    private static Dropdown vegetables;

    @UI("button#submit-button")
    private static Button submit;

    @UI("ul[class = 'panel-body-list results'] li")
    private static UIElement result;

    public void fillForm(MetalAndColorsData metalAndColorsData) {

        for (Integer summaryInt : metalAndColorsData.getSummary()) {
            summary.select(summaryInt.toString());
        }

        for (String elementText : metalAndColorsData.getElements()) {
            elements.select(elementText);
        }

        colors.expand();
        colors.select(metalAndColorsData.getColor());

        metals.expand();
        metals.select(metalAndColorsData.getMetals());

        vegetables.expand();
        vegetables.select("Vegetables");
        for (String vegetablesText : metalAndColorsData.getVegetables()) {
            vegetables.select(vegetablesText);
        }
    }

    public void clickSubmitButton() {
        submit.click();
    }
}
