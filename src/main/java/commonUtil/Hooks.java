package commonUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import ui.common.configReader;
import ui.config.DriverFactory;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){

        // 1. Initialize driver
        WebDriver driver = DriverFactory.initDriver();

        // 2. Store driver & scenario
        Store.setDriver(driver);
        Store.setScenario(scenario);

        // 3. Browser setup
        driver.manage().window().maximize();

        // 4. Timeouts (safe defaults)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // 5. Logging
        Store.getScenario().log("Driver initialized and browser launched");

        // 6. Navigate to application
        String url = configReader.get("url");
        Store.getScenario().log("Navigating to URL: " + url);

        driver.get(url);
    }

    @After
    public void tearDown(){

        WebDriver driver = Store.getDriver();

        if(driver != null){
            driver.quit();
        }

        Store.clear();
    }
}