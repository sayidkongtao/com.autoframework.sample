package autoframework.listener;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenCapture {

    private static Logger logger = LogManager.getLogger(ScreenCapture.class);

    public static void getScreen(TakesScreenshot driver, String filename) {
        try {

            File scrFile = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(filename));
            logger.info("GetScreenshot Successful: " + filename);
        } catch (Exception e) {
            logger.error(e);
            logger.error("GetScreenshot Fail for: " + filename);
        }
    }
}
