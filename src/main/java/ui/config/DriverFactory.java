package ui.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import ui.common.configReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(){

        String browser = configReader.get("browser");
        String headless = System.getProperty("headless", "false");

        switch (browser.toLowerCase()) {

            case "chrome":

                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (headless.equalsIgnoreCase("true")) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (headless.equalsIgnoreCase("true")) {
                    firefoxOptions.addArguments("--headless");
                }

                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        if (driver.get() == null) {
            throw new RuntimeException("Driver initialization failed");
        }

        if (!headless.equalsIgnoreCase("true")) {
            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}