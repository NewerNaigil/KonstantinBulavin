package ru.training.at.hw5.page.components;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableOld extends AbstractComponent {

    public TableOld(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "#user-table tbody tr")
    private List<WebElement> rowList;
    @FindBy(xpath = "//table[@id = 'user-table']//th")
    private List<WebElement> tableHead;

    public void demo() {

    }

    //    public List<Object> getTableText() {
    //        String number;
    //        String user;
    //        String description;
    //        List<Object> result = new ArrayList<>();
    //        if (result.get(0) == null) {
    //            result.add(new Row(tableHead.get(0).getText(), tableHead.get(1).getText(), tableHead.get(2).getText(),
    //                tableHead.get(3).getText()));
    //        }
    //
    //        int count = rowList.size();
    //
    //        for (int i = 1; i < count; i++) {
    //
    //        }
    //
    //        //table[@id = 'user-table']/tbody/tr[1]/td
    //
    //    }

    //    class Row {
    //        String numberHead;
    //        String typeHead;
    //        String userHead;
    //        String descriptionHead;
    //
    //        WebElement numberBody;
    //        WebElement typeBody;
    //        WebElement userBody;
    //        WebElement descriptionBody;
    //
    //        String number;
    //        String type;
    //        String user;
    //        String description;
    //
    //        int i;
    //
    //        public Row(String numberHead, String typeHead, String userHead, String descriptionHead) {
    //            this.numberHead = numberHead;
    //            this.typeHead = typeHead;
    //            this.userHead = userHead;
    //            this.descriptionHead = descriptionHead;
    //        }
    //
    //        public Row(int x) {
    //            numberBody = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr["+ x +"]/td"));
    //            typeBody = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr["+ x +"]//select"));
    //            userBody = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr["+ x +"]//a"));
    //            descriptionBody =
    //            webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr["+ x +"]//span"));
    //        }
    //
    //        public Row getText() {
    //            return this;
    //        }
    //
    //
    //        //public String createRow(int x) {
    //            //numberBody = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[1]/td"));
    //            //typeBody = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[1]//select"));
    //            //userBody = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[1]//a"));
    //            //descriptionBody = webDriver.findElement(By.xpath("//table[@id = 'user-table']/tbody/tr[1]//span"));
    //
    //        }
}

//    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
//    And 6 Usernames should be displayed on Users Table on User Table Page
//    And 6 Description texts under images should be displayed on Users Table on User Table Page
//    And 6 checkboxes should be displayed on Users Table on User Table Page
//    And User table should contain following values:
//        | Number | User             | Description                      |
//        | 1      | Roman            | Wolverine                        |
//        | 2      | Sergey Ivan      | Spider man                       |
//        | 3      | Vladzimir        | Punisher                         |
//        | 4      | Helen Bennett    | Captain America some description |
//        | 5      | Yoshi Tannamuri  | Cyclope some description         |
//        | 6      | Giovanni Rovelli | Hulksome description             |
//    And droplist should contain values in column Type for user Roman
//          | Dropdown Values |
//        | Admin           |
//        | User            |
//        | Manager         |
