package autoframework.testcaes.basetest;

import autoframework.common.basepage.BasePage;
import autoframework.listener.ScreenCaptureListener;
import autoframework.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Listeners({ScreenCaptureListener.class})
public class BaseTest {

    public static AppiumDriver<MobileElement> driver;
    protected static Logger logger = LogManager.getLogger(AppiumDriver.class);

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        logger.info("********************测试套件开始执行********************");

        File reportDir = new File(BasePage.OUTPUT_FOLDER);
        if (!reportDir.exists() && !reportDir.isDirectory()) {
            reportDir.mkdir();
        }
    }

    @BeforeClass
    public void classSetup() {
    }

    @BeforeMethod
    public void methodSetup() throws MalformedURLException {
        //https://github.com/truongsinh/appium-flutter-driver/issues/44
        initIOSDriver();
    }

    @AfterMethod
    public void afterMethod() {
        logger.info("关闭驱动");
        driver.quit();
    }

    @AfterSuite
    public void closeDriver() {
        logger.info("********************测试套件执行结束********************");
    }

    public static void initAndroidDriver() throws MalformedURLException {
        logger.info("********************初始化Android Driver*******************");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", System.getProperty("APPIUM_DEVICE_NAME", "AKC7N18907000186"));
        capabilities.setCapability("platformVersion", System.getProperty("APPIUM_DEVICE_VERSION", "9"));
        capabilities.setCapability("automationName", "Flutter");
        capabilities.setCapability("platformName", System.getProperty("APPIUM_PLATFORM", "Android"));
        capabilities.setCapability("appPackage", "com.taobao.idlefish.flutterboostexample");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("newCommandTimeout", 7200);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);

        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.put("androidProcess", "com.tencent.mm:tools");
        //chromeOptions.setExperimentalOption("w3c", false);
        // capabilities.merge(chromeOptions);
        capabilities.setCapability("chromedriverChromeMappingFile", Utils.getAbsolutePath("chromdrivermap/map.json"));
        capabilities.setCapability("chromedriverExecutableDir", Utils.getAbsolutePath("chromedriver"));


        /**
         * need to add x right to file
         */
        File file = new File(Utils.getAbsolutePath("chromedriver"));
        List<File> files = Arrays.asList(file.listFiles());

        files.forEach(ele -> {
            try {
                ele.getAbsolutePath();
                Runtime.getRuntime().exec(String.format("chmod +x %s", ele.getAbsolutePath()));
            } catch (IOException ignore) {
                //ignore.printStackTrace();
            }
        });

        try {
            driver = new AndroidDriver(new URL(System.getProperty("APPIUM_URL", "http://127.0.0.1:4723/wd/hub")), capabilities);
        } catch (Exception err) {
            logger.info("Android Driver初始化失败，错误详细信息参考如下");
            logger.error(err);
            throw err;
        }

        logger.info("Android Driver初始化成功");
    }

    public static void initIOSDriver() throws MalformedURLException {
        logger.info("********************测试套件开始执行********************");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", System.getProperty("APP_DEVICE_NAME", "iPhone"));
        capabilities.setCapability("platformVersion", System.getProperty("APP_DEVICE_VERSION", "12.2"));
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("udid", System.getProperty("APPIUM_DEVICE_UDID", "029d553ea04ba899509dc0630fda19bdac61231a"));
        capabilities.setCapability("platformName", System.getProperty("APP_DEVICE_PLATFORMNAME", "iOS"));
        capabilities.setCapability("bundleId", System.getProperty("APP_BUNDLEIDENTIFIER", "com.xiaomi.mihome.dailybuild"));
        capabilities.setCapability("webDriverAgentUrl", System.getProperty("WEBDRIVERAGENT_URL", "http://localhost:8100"));
        capabilities.setCapability("newCommandTimeout", 7200);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");

        try {
            driver = new IOSDriver<>(new URL(System.getProperty("APPIUM_URL", "http://127.0.0.1:4723/wd/hub")), capabilities);
        } catch (Exception err) {
            logger.error(err);
            throw err;
        }
        logger.info("驱动对象创建完毕");
    }

    public AppiumDriver<MobileElement> getDriver() {
        return this.driver;
    }
}
