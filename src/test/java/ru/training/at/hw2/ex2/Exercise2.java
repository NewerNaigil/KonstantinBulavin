package ru.training.at.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.ProperTestData;
import ru.training.at.hw2.Tags;

public class Exercise2 {

    private List<WebElement> webElementList;

    @Test(groups = Tags.HW2)
    public void differentElementsPageTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // 1. Open test site by URL
        driver.manage().window().maximize();
        // timeouts
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        driver.findElement(By.cssSelector("a[href = '#']")).click();
        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Roman");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        driver.navigate().refresh();

        // 4. Assert User name in the left-top side of screen that user is loggined.
        Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector("ul[class='sidebar-menu left']  li[class = 'menu-title'][index = '3']"))
              .click();
        driver.findElement(By.cssSelector("ul[class='sidebar-menu left']  a[href='different-elements.html']")).click();

        // 6. Select checkboxes
        webElementList = driver.findElements(By.cssSelector("label[class = 'label-checkbox']"));
        for (WebElement webElement : webElementList) {
            if (webElement.getText().equals("Water") || webElement.getText().equals("Wind")) {
                webElement.click();
            }
        }

        // 7. Select radio
        webElementList = driver.findElements(By.cssSelector("label[class = 'label-radio']"));
        webElementList = driver.findElements(By.cssSelector("label[class = 'label-radio']"));
        for (WebElement webElement : webElementList) {
            if (webElement.getText().equals("Selen")) {
                webElement.click();
            }
        }

        // 8. Select in dropdown
        new Select(driver.findElement(By.cssSelector("select[class='uui-form-element']")))
            .selectByVisibleText("Yellow");

        // 9. Assert checkboxes, radio and dropdown menu.
        webElementList = driver.findElements(By.cssSelector("ul[class='panel-body-list logs'] li"));
        for (WebElement webElement : webElementList) {
            boolean marker = false;
            for (String expected : ProperTestData.LOGS) {
                if (webElement.getText().contains(expected)) {
                    marker = true;
                }
            }
            Assert.assertTrue(marker);
        }

        // 10. Close Browser
        driver.close();
    }
}

