package autoframework.common.basepageobject;

import autoframework.common.webutils.WebUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {

    protected SearchContext searchContext;
    protected WebUtils webUtils;

    public BasePageObject(RemoteWebDriver remoteWebDriver, WebUtils webUtils) {
        this.searchContext = remoteWebDriver;
        this.webUtils = webUtils;
        PageFactory.initElements(new AppiumFieldDecorator(searchContext), this);
    }

    public BasePageObject(RemoteWebDriver remoteWebDriver, SearchContext searchContext, WebUtils webUtils) {
        this.searchContext = searchContext;
        this.webUtils = webUtils;
        PageFactory.initElements(new AppiumFieldDecorator(searchContext), this);
    }

}
