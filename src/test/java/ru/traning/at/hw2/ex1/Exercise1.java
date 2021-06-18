package ru.traning.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.traning.at.hw2.ProperTestData;

public class Exercise1 {

    private WebElement webElement;
    private List<WebElement> webElementList;
    private Set<String> actualSet = new HashSet<>();

    @Test
    public void indexPageTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // 1. Open test site by URL
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        driver.findElement(By.cssSelector("a[href = '#']")).click();
        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("Roman");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        driver.navigate().refresh();

        // 4. Assert Username is loggined
        Assert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        webElementList = driver.findElements(By.xpath("//ul[@class = 'uui-navigation nav navbar-nav m-l8']/li/a"));
        for (WebElement webElement : webElementList) {
            actualSet.add(webElement.getText());
        }

        Assert.assertEquals(actualSet, ProperTestData.HEADER_SELECTOR_ITEMS_SET);
        actualSet.clear();

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        webElementList = driver.findElements(By.xpath("//Img[contains (@src, images)]"));
        driver.switchTo().frame("first_frame");

        webElement = driver.findElement(By.xpath("//Img[contains (@src, images)]"));
        Assert.assertTrue(webElement.isDisplayed());
        webElementList.addAll(driver.findElements(By.xpath("//Img[contains (@src, images)]")));

        driver.switchTo().defaultContent();
        driver.switchTo().frame("second_frame");
        driver.switchTo().frame("frame_in_frame");

        webElement = driver.findElement(By.xpath("//Img[contains (@src, images)]"));
        Assert.assertTrue(webElement.isDisplayed());
        webElementList.addAll(driver.findElements(By.xpath("//Img[contains (@src, images)]")));
        driver.switchTo().defaultContent();

        Assert.assertEquals(webElementList.size(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        webElementList = driver.findElements(By.xpath("//span [@class = 'benefit-txt']"));
        for (WebElement webElement : webElementList) {
            actualSet.add(webElement.getText());
        }
        Assert.assertEquals(actualSet, ProperTestData.TEXT_UNDER_ICON_SET);
        actualSet.clear();

        // 8. Assert that there is the iframe with “Frame Button” exist
        webElementList = driver.findElements(By.xpath("//iframe[@id = 'frame' and contains (src, frame-button)]"));
        Assert.assertTrue(webElementList.size() > 0);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        webElementList = driver.findElements(By.id("frame-button"));
        Assert.assertTrue(webElementList.size() > 0);

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        webElementList = driver.findElements(By.cssSelector("ul[class = 'sidebar-menu left'] > li"));
        for (WebElement webElement : webElementList) {
            Assert.assertTrue(webElement.isDisplayed());
        }

        for (WebElement webElement : webElementList) {
            actualSet.add(webElement.getText());
        }
        Assert.assertEquals(actualSet, ProperTestData.TEXT_LEFT_SECTION_SET);

        // 12. Close Browser
        driver.close();
    }
}
