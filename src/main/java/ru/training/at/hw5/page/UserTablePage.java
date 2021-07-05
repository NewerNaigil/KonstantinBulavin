package ru.training.at.hw5.page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.page.components.RowNew;

public class UserTablePage extends AbstractPage {

    private RowNew rowNew;

    @FindBy(css = "#user-table tbody tr")
    private List<WebElement> rowList;
    @FindBy(xpath = "//a[text() = 'Roman']/../preceding-sibling::td//option")
    private List<WebElement> dropdownOptionList;
    //    @FindBy(xpath = "//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]/td")
    //    private WebElement number;
    //    @FindBy(xpath = "//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//select")
    //    private WebElement type;
    //    @FindBy(xpath = "//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//a")
    //    private WebElement username;
    //    @FindBy(xpath = "//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//span")
    //    private WebElement description;
    //    @FindBy(xpath = "//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//input")
    //    private WebElement checkbox;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> getListNumbers() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]/td")));
        }
        return result;
    }

    public List<WebElement> getListType() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]//select")));
        }
        return result;
    }

    public List<WebElement> getListUsername() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]//a")));
        }
        return result;
    }

    public List<WebElement> getListDescription() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]//span")));
        }
        return result;
    }

    public List<WebElement> getListCheckbox() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]//input")));
        }
        return result;
    }


    public List<String> getTextDropdownOptions() {

        List<String> result = new ArrayList<>();
        result.add("Dropdown Values");

        dropdownOptionList.stream()
                .map(WebElement::getText)
                .forEach(result::add);

        return result;
    }

    public List<List<String>> getTextTable() {

        List<List<String>> rows = new ArrayList<>();

        for (int i = 0; i <= rowList.size(); i++) {
            List<String> columns = new ArrayList<>();
            if (i == 0) {
                columns.add(webDriver.findElement(By.xpath("//th[text() = 'Number']")).getText());
                columns.add(webDriver.findElement(By.xpath("//th[text() = 'User']")).getText());
                columns.add(webDriver.findElement(By.xpath("//th[text() = 'Description']")).getText());
                rows.add(columns);
            } else {
                columns.add(
                    webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]/td"))
                             .getText());
                columns.add(
                    webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]//a"))
                             .getText());
                columns.add(
                    webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + i + "]//span"))
                             .getText());

                rows.add(columns.stream()
                                .map(x -> x.replaceAll("\n", " "))
                                .collect(Collectors.toList()));
            }
        }
        System.out.println(rows.size());
        return rows;
    }

    //    public void createTable() {
    //        for (int i = 0; i <= rowList.size(); i++) {
    //            userTable.add(new Row(webDriver, i));
    //        }
    //    }
    //
    //    public List<WebElement> getListNumbers() {
    //        return userTable.stream()
    //                        .map(Row::getNumber)
    //                        .filter(f -> !f.getText().equals("Number"))
    //                        .filter(WebElement::isDisplayed)
    //                        .collect(Collectors.toList());
    //    }
    //
    //    public List<WebElement> getListUsername() {
    //        return userTable.stream()
    //                        .map(Row::getUser)
    //                        .filter(f -> !f.getText().equals("User"))
    //                        .filter(WebElement::isDisplayed)
    //                        .collect(Collectors.toList());
    //    }
    //
    //    public List<WebElement> getListDescriptionText() {
    //        return userTable.stream()
    //                        .map(Row::getDescription)
    //                        .filter(f -> !f.getText().equals("Description"))
    //                        .filter(WebElement::isDisplayed)
    //                        .collect(Collectors.toList());
    //    }
    //
    //    public List<WebElement> getListCheckbox() {
    //        return userTable.stream()
    //                        .map(Row::getCheckbox)
    //                        .filter(f -> !f.getText().equals("Description"))
    //                        .filter(WebElement::isDisplayed)
    //                        .collect(Collectors.toList());
    //    }
    //
    //    public void selectCheckbox(String userName) {
    //        userTable.stream()
    //                 .filter(f -> f.getUser().getText().equals(userName))
    //                 .forEach(f -> f.getCheckbox().click());
    //    }
}
