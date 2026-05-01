package ui.pageObjects;

import commonUtil.Store;
import commonUtil.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(){
        this.driver = Store.getDriver();
    }
    private final By usernameField = By.name("username");

    public boolean isLoginPageDisplayed(){
        return WebDriverActions
                .waitForElementVisible(usernameField)
                .isDisplayed();
    }
}
