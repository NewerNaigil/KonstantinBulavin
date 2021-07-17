package ru.training.at.hw7.page;

import com.epam.jdi.light.elements.composite.WebPage;
import ru.training.at.hw7.entities.MetalAndColorsData;
import ru.training.at.hw7.forms.MetalAndColorsForm;
import ru.training.at.hw7.section.RightSideResultSection;

public class JdiMetalAndColorsPage extends WebPage {

    public MetalAndColorsForm metalAndColorsForm;
    public RightSideResultSection rightSideResultSection;

    public void fillMT(MetalAndColorsData metalAndColorsData) {
        metalAndColorsForm.add(metalAndColorsData);
    }

    //    @UI("p.radio")
    //    private static RadioButtons summary;
    //
    //    @UI("p.checkbox")
    //    private static Checklist elements;
    //
    //    @JDropdown(
    //        root = "div#colors",
    //        list = "div#colors li",
    //        expand = "div#colors .caret"
    //    )
    //    private static Dropdown colors;
    //
    //    @JDropdown(root = "div#metals",
    //               list = "div#metals li",
    //               expand = "div#metals .caret"
    //    )
    //    private static Dropdown metals;
    //
    //    @JDropdown(root = "#vegetables",
    //               list = "#vegetables li",
    //               expand = "#vegetables .caret")
    //    private static Dropdown vegetables;
    //
    //    @UI("button#submit-button")
    //    private static Button submit;
    //
    //    @UI("ul[class = 'panel-body-list results'] li")
    //    private static UIElement result;
}
