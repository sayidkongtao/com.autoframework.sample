package autoframework.demo;

import autoframework.demo.page.StartPage;
import autoframework.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import autoframework.testcaes.basetest.BaseTest;

/**
 * @author Sayid
 * 测试Demo
 */

public class TestDemoModule extends BaseTest {
    private Logger logger = LogManager.getLogger(TestDemoModule.class);

    public void simpleTestThree() throws MalformedURLException {

        StartPage firstPage = new StartPage(driver);
        firstPage.basicSteps();

        Utils.sleepBySecond(3);
        logger.info("测试完成");
    }

    @Test
    public void simpleTest() throws MalformedURLException {

        StartPage firstPage = new StartPage(driver);
        firstPage.basicSteps();

        Utils.sleepBySecond(3);
        logger.info("测试完成");
    }
}
