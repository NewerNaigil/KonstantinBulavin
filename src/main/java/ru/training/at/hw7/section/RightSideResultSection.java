package ru.training.at.hw7.section;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import java.util.ArrayList;
import java.util.List;

public class RightSideResultSection extends Section {

    @UI("ul[class='panel-body-list results'] li")
    private List<UIElement> logsList;

    public List<String> getLogsListText() {
        List<String> logText = new ArrayList<>();
        for (UIElement log : logsList) {
            logText.add(log.getText());
        }
        return logText;
    }
}
