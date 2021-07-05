package ru.training.at.hw5.page.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Row extends AbstractComponent {

    private WebElement number;
    private WebElement type;
    private WebElement user;
    private WebElement description;
    private WebElement checkbox;

    public Row(WebDriver webDriver, int rowsNumber) {
        super(webDriver);

        if (rowsNumber == 0) {
            number = webDriver.findElement(By.xpath("//th[text() = 'Number']"));
            type = webDriver.findElement(By.xpath("//th[text() = 'Type']"));
            user = webDriver.findElement(By.xpath("//th[text() = 'User']"));
            description = webDriver.findElement(By.xpath("//th[text() = 'Description']"));
            checkbox = webDriver.findElement(By.xpath("//th[text() = 'Description']"));
        } else {
            number = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]/td"));
            type = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//select"));
            user = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//a"));
            description =
                webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//span"));
            checkbox =
                webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + rowsNumber + "]//input"));
        }
    }

    public WebElement getNumber() {
        return number;
    }

    public WebElement getType() {
        return type;
    }

    public WebElement getUser() {
        return user;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }
}


