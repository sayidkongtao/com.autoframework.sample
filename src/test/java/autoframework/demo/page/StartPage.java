package autoframework.demo.page;

import autoframework.common.basepage.BasePage;
import autoframework.demo.pageobject.StartPageObject;
import autoframework.utils.Utils;
import io.appium.java_client.AppiumDriver;

public class StartPage extends BasePage {

    private StartPageObject pageObject;

    public StartPage(AppiumDriver driver) {
        super(driver);
        pageObject = new StartPageObject(driver, webUtils);
    }

    public void basicSteps() {
        logger.info("从首页进入到摄像机");
        try {
            webUtils.click(pageObject.camera, 5, 500);
        }catch (Exception e) {
            webUtils.inputText(pageObject.uerName, "");
            webUtils.inputText(pageObject.passWord, "");
            webUtils.click(pageObject.login);
            webUtils.click(pageObject.camera, true);
        }

        Utils.sleepBySecond(2);

        logger.info("打开电话按钮");
        webUtils.click(pageObject.hlcardCommonCalloffNormal, true);

        Utils.sleepBySecond(3);

        logger.info("关闭电话按钮");
        webUtils.click(pageObject.hlcardCommonCallNormal, true);

        logger.info("打开声音");
        webUtils.click(pageObject.mjcardPlayviewMuteNormal, true);

        logger.info("关闭声音");
        webUtils.click(pageObject.mjcardPlayviewUnMuteNormal, true);

        logger.info("让摄像头进入睡眠模式");
        webUtils.click(pageObject.hlcardPlayviewSleepNormal, true);

        logger.info("不让摄像头进入睡眠模式");
        webUtils.click(pageObject.cameraIsInSleepMode, true);
        Utils.sleepBySecond(2);

        logger.info("开始截图");
        webUtils.click(pageObject.screenShot, true);

        Utils.sleepBySecond(2);
        logger.info("开始摄像");
        webUtils.click(pageObject.cameraShot, true);
        Utils.sleepBySecond(10);
        logger.info("停止摄像");
        webUtils.click(pageObject.cameraShotStop, true);


        logger.info("进入到设置页面");
        webUtils.click(pageObject.hlcardCameraNavigationOnMor, true);
        webUtils.click(pageObject.settings, true);

        logger.info("开关前三个按钮");
        webUtils.click(pageObject.statusLight, true);
        Utils.sleepBySecond(3);
        webUtils.click(pageObject.dataUsage, true);
        webUtils.click(pageObject.smartFrame, true);

    }
}
