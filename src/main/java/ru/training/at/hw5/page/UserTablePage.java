package ru.training.at.hw5.page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractPage {

    @FindBy(css = "#user-table tbody tr")
    private List<WebElement> rowList;
    @FindBy(xpath = "//a[text() = 'Roman']/../preceding-sibling::td//option")
    private List<WebElement> dropdownOptionList;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> getListNumbers() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//tr[" + i + "]/td")));
        }
        return result;
    }

    public List<WebElement> getListType() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//tr[" + i + "]//select")));
        }
        return result;
    }

    public List<WebElement> getListUsername() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//tr[" + i + "]//a")));
        }
        return result;
    }

    public List<WebElement> getListDescription() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//tr[" + i + "]//span")));
        }
        return result;
    }

    public List<WebElement> getListCheckbox() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 1; i <= rowList.size(); i++) {
            result.add(webDriver.findElement(By.xpath("//tr[" + i + "]//input")));
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
                columns.add(webDriver.findElement(By.xpath("//tr[" + i + "]/td")).getText());
                columns.add(webDriver.findElement(By.xpath("//tr[" + i + "]//a")).getText());
                columns.add(webDriver.findElement(By.xpath("//tr[" + i + "]//span")).getText());

                rows.add(columns.stream()
                                .map(x -> x.replaceAll("\n", " "))
                                .collect(Collectors.toList()));
            }
        }
        return rows;
    }
}
