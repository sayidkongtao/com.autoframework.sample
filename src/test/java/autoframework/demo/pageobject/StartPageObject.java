package autoframework.demo.pageobject;

import autoframework.common.basepageobject.BasePageObject;
import autoframework.common.webutils.WebUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;

public class StartPageObject extends BasePageObject {
    public StartPageObject(RemoteWebDriver remoteWebDriver, WebUtils webUtils) {
        super(remoteWebDriver, webUtils);
    }

    //For Native Element location
    @CacheLookup
    @iOSXCUITFindBy(id = "Don’t Allow")
    public MobileElement deny;

    //LogPage
    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"MiPassport.bundle/images/invisible\"]/parent::XCUIElementTypeOther//XCUIElementTypeTextField")
    public MobileElement uerName;

    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"MiPassport.bundle/images/invisible\"]/preceding-sibling::XCUIElementTypeSecureTextField")
    public MobileElement passWord;

    @CacheLookup
    @iOSXCUITFindBy(id = "Sign in")
    public MobileElement login;


    //homePage
    @CacheLookup
    @iOSXCUITFindBy(id = "Ok")
    public MobileElement homeDataOk;

    @CacheLookup
    @iOSXCUITFindBy(id = "Ok")
    public MobileElement microPhoneOk;

    @CacheLookup
    @iOSXCUITFindBy(id = "Ok")
    public MobileElement privacyOk;

    //摄像头
    @iOSXCUITFindBy(id = "摄像机")
    public MobileElement camera;

    //3分钟
    @CacheLookup
    @iOSXCUITFindBy(id = "Agree and continue")
    public MobileElement agreeAndContinue;

    //hlcard common calloff normal
    @CacheLookup
    @iOSXCUITFindBy(id = "hlcard common calloff normal")
    public MobileElement hlcardCommonCalloffNormal;
    @CacheLookup
    @iOSXCUITFindBy(id = "hlcard common call normal")
    public MobileElement hlcardCommonCallNormal;

    @CacheLookup
    @iOSXCUITFindBy(id = "mjcard playview mute normal")
    public MobileElement mjcardPlayviewMuteNormal;
    @CacheLookup
    @iOSXCUITFindBy(id = "mjcard playview unmute normal")
    public MobileElement mjcardPlayviewUnMuteNormal;

    @CacheLookup
    @iOSXCUITFindBy(id = "hlcard playview sleep normal")
    public MobileElement hlcardPlayviewSleepNormal;
    @CacheLookup
    @iOSXCUITFindBy(id = "Camera is in Sleep mode")
    public MobileElement cameraIsInSleepMode;

    //截图 mjcard playview shot normal
    @CacheLookup
    @iOSXCUITFindBy(id = "mjcard playview shot normal")
    public MobileElement screenShot;

    //摄像 mjcard playview record normal
    @CacheLookup
    @iOSXCUITFindBy(id = "mjcard playview record normal")
    public MobileElement cameraShot;
    //mjcard playview recordon norma
    @CacheLookup
    @iOSXCUITFindBy(id = "mjcard playview recordon norma")
    public MobileElement cameraShotStop;

    //进入Setting
    @CacheLookup
    @iOSXCUITFindBy(id = "hlcard camera navigation onMor")
    public MobileElement hlcardCameraNavigationOnMor;
    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings\"]")
    public MobileElement settings;
    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Status light\"]")
    public MobileElement statusLight;
    @CacheLookup
    @iOSXCUITFindBy(id = "Data usage warning, Only play the videos automatically when Wi-Fi is connected")
    public MobileElement dataUsage;
    @CacheLookup
    @iOSXCUITFindBy(id = "Smart frame, Mark the detected movements or figures in the picture")
    public MobileElement smartFrame;

    //Back
    @CacheLookup
    @iOSXCUITFindBy(id = "Back")
    public MobileElement back;

    //台灯
    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Desk lamp\"]")
    public MobileElement deskLamp;

    //on 模式
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"On\" or @name=\"Off\"]/preceding-sibling::XCUIElementTypeOther")
    public MobileElement onOrOffBtn;

    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Custom\"]/preceding-sibling::XCUIElementTypeOther")
    public MobileElement customBtn;

    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reading\"]/preceding-sibling::XCUIElementTypeOther")
    public MobileElement readingBtn;

    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PC mode\"]/preceding-sibling::XCUIElementTypeOther")
    public MobileElement pcMode;

    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"On\" or @name=\"Off\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther[contains(@name, \"Focus\")]/XCUIElementTypeOther/XCUIElementTypeOther")
    public MobileElement focusModeSwitchBtn;

    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"On\" or @name=\"Off\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther[contains(@name, \"Focus\")]/XCUIElementTypeOther[2]")
    public MobileElement focusModeRightBtn;
    //---


    @CacheLookup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Favorites\"]/preceding-sibling::XCUIElementTypeOther")
    public MobileElement favorites;
}
