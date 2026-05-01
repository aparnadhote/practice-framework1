package ui.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.common.configReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver>  driver= new ThreadLocal<>();

    public static WebDriver initDriver(){
        String browser = configReader.get("browser");
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }
}
