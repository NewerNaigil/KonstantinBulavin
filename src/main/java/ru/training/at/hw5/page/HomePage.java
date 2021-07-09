package ru.training.at.hw5.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.page.components.Frame;
import ru.training.at.hw5.page.components.HeaderMenu;
import ru.training.at.hw5.page.components.LeftSideMenu;
import ru.training.at.hw5.page.components.LoginForm;

public class HomePage extends AbstractPage {

    private static final String PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private LoginForm loginForm;
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;
    private Frame frame;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textUnderIconList;
    @FindBy(id = "frame")
    private List<WebElement> listOfFrameWithButton;
    @FindBy(xpath = "//Img[contains (@src, images)]")
    private List<WebElement> listOfImage;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        loginForm = new LoginForm(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        leftSideMenu = new LeftSideMenu(webDriver);
        frame = new Frame(webDriver);
    }

    public void openPage() {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(PAGE_URL);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void login(String login, String password) {
        loginForm.login(login, password);
        webDriver.navigate().refresh();
    }

    public void switchToFrame(String frameName) {
        webDriver.switchTo().frame(frameName);
    }

    public List<WebElement> getTextUnderIcon() {
        return textUnderIconList;
    }

    public List<WebElement> getListOfFrameWithButton() {
        return listOfFrameWithButton;
    }

    public List<WebElement> getListOfImage() {
        List<WebElement> allImageList = new ArrayList<>(listOfImage);
        switchToFrame("first_frame");
        allImageList.addAll(listOfImage);
        getFrame().returnToHomePage();
        switchToFrame("second_frame");
        switchToFrame("frame_in_frame");
        allImageList.addAll(listOfImage);
        getFrame().returnToHomePage();
        return allImageList;
    }

    public Frame getFrame() {
        return frame;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }
}
