package ru.training.at.hw5.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

    private static WebDriver webDriver;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(driver.get())) {
            driver.set(WebDriverFactory.createWebDriver(browserName));
        }
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }

    //    public static WebDriver getDriver() {
    //        if (Objects.isNull(webDriver)) {
    //            WebDriverManager.chromedriver().setup();
    //            webDriver = new ChromeDriver();
    //            webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    //        }
    //        return webDriver;
    //    }
    //
    //    public static void shutdownDriver() {
    //        if (webDriver != null) {
    //            webDriver.quit();
    //        }
    //    }
}
