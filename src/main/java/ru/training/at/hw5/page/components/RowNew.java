package ru.training.at.hw5.page.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RowNew extends AbstractComponent {

    int numberOfRow;

    public RowNew(WebDriver webDriver, int numberOfRow) {
        super(webDriver);
        this.numberOfRow = numberOfRow;
    }

    public WebElement getNumber() {
        return webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + numberOfRow + "]/td"));
    }

    public WebElement getType() {
        return webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + numberOfRow + "]//select"));
    }

    public WebElement getUser() {
        return webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + numberOfRow + "]//a"));
    }

    public WebElement getDescription() {
        return webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + numberOfRow + "]//span"));
    }

    public WebElement getCheckbox() {
        return webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[" + numberOfRow + "]//input"));
    }
}
