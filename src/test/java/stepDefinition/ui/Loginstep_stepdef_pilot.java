package stepDefinition.ui;

import commonUtil.Store;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import ui.pageObjects.LoginPage;
import org.apache.logging.log4j.Logger;
import commonUtil.LoggerUtil;

public class Loginstep_stepdef_pilot {

    LoginPage loginPage = new LoginPage();
    private static final Logger log = LoggerUtil.getLogger(Loginstep_stepdef_pilot.class);

    @Given("user launches the application")
    public void launch_application(){
        log.info("Verifying login page");
        boolean isDisplayed = loginPage.isLoginPageDisplayed();

        Assert.assertTrue(isDisplayed, "Login page is not displayed");

        // 🔥 Force failure
//        Assert.assertTrue(false, "Force failure to test screenshot");

        log.info("Login page verified successfully");
        Store.getScenario().log("Application launched successfully and login page is visible");
    }
}
