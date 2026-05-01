package commonUtil;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverActions {

    private static final Logger log = LoggerUtil.getLogger(WebDriverActions.class);

    private static WebDriver getDriver() {
        return Store.getDriver();
    }

    public static WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public static WebElement waitForElementVisible(By locator){

        log.info("Waiting for element to be visible: {}", locator);

        try {
            WebElement element = getWait().until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );

            log.info("Element is visible: {}", locator);
            return element;

        } catch (Exception e) {
            log.error("Element NOT visible within timeout: {}", locator);
            throw e; // important → don’t swallow exception
        }
    }
}