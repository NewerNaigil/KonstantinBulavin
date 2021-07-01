package ru.training.at.hw4.page;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw4.page.components.RightSideLogForm;

public class DifferentElementsPage extends AbstractPage {

    RightSideLogForm rightSideLogForm;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxList;
    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonList;
    @FindBy(css = "select[class='uui-form-element']")
    private WebElement dropdownMenu;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        rightSideLogForm = new RightSideLogForm(webDriver);
    }

    public void selectCheckbox(String checkboxText) {
        for (WebElement checkbox : checkboxList) {
            if (checkbox.getText().equals(checkboxText)) {
                checkbox.click();
            }
        }
    }

    public void selectRadioButton(String radioButtonText) {
        for (WebElement radioButton : radioButtonList) {
            if (radioButton.getText().equals(radioButtonText)) {
                radioButton.click();
            }
        }
    }

    public void selectDropdownMenu(String color) {
        new Select(dropdownMenu).selectByVisibleText(color);
    }

    public Set<String> getLogRows() {
        return rightSideLogForm.getLogsList().stream()
                               .map(x -> x.getText().substring(9))
                               .collect(Collectors.toSet());
    }
}
