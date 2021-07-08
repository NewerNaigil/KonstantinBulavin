package ru.training.at.hw6.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import javax.management.openmbean.InvalidOpenTypeException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private static final String OPERA = "OPERA";
    private static final String EDJE = "MicrosoftEdge";

    private static final String REMOTE_DRIVER_TYPE = "remote";
    private static final String LOCAL_DRIVER_TYPE = "local";

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(String browserName) {
        WebDriver driver;
        switch (browserName.toUpperCase()) {
            case FIREFOX:
                driver = createFirefox();
                break;
            case CHROME:
                driver = createChrome();
                break;
            case OPERA:
                driver = createOpera();
                break;
            default:
                driver = createChrome();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createWebDriver(String driverType, String browserName) {
        if (LOCAL_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createWebDriver(browserName);
        } else {
            if (REMOTE_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
                return createRemoteDriver(browserName);
            } else {
                throw new IllegalArgumentException("Unsupported driver type %s.");
            }
        }
    }

    private static WebDriver createRemoteDriver(String browserName) {
        Capabilities capabilities = null;
        if (CHROME.equalsIgnoreCase(browserName)) {
            capabilities = createChromeCapabilities();
        } else {
            if (FIREFOX.equalsIgnoreCase(browserName)) {
                capabilities = createFirefoxCapabilities();
            } else {
                throw new IllegalArgumentException("Unsupported browser type %s.");
            }
        }

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new InvalidOpenTypeException("Incorrect Selenium Grid URL");
        }
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createChromeCapabilities() {
        return new FirefoxOptions();
    }

    private static WebDriver createFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createOpera() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
