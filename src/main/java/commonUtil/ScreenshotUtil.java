package commonUtil;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {
    public static byte[] captureScreenshot(String scenarioName) {

        try {
            WebDriver driver = Store.getDriver();

            String safeName = scenarioName.replaceAll(" ", "_");
            String timestamp = String.valueOf(System.currentTimeMillis());

            byte[] screenshotBytes = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            String path = "target/screenshots/" + safeName + "_" + timestamp + ".png";

            Files.createDirectories(Paths.get("target/screenshots"));

            Files.write(Paths.get(path), screenshotBytes);

            System.out.println("Screenshot saved at: " + path);

            return screenshotBytes;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
