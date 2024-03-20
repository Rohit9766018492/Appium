import BaseLayer.AndroidBaseClass;
import BaseLayer.StartAppiumByCode;
import Utility.Listener;
import Utility.SetData;
import Utility.getData;
import io.appium.java_client.MobileDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.locatorsAndMethods;


import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Listener.class)
public class TestClass extends locatorsAndMethods {
    public static Logger logg= LogManager.getLogger(TestClass.class);
    AndroidBaseClass base=new AndroidBaseClass();
   @Test
    public void GoogleAppLaunch()
    {
//        launchApp();
        logg.info("Application Launch");
        changeOrientationToLandscape();
        wait(5000);
        mobileAlertHandle();
        restartApp();
        Assert.assertTrue(isElementDisplay(googleNewsTitle),"Google title is not Displayed");
        logg.info("Google news title present");
        log.info("Clicking on five button");
        Assert.assertTrue(isElementDisplay(search),"Plus is not Displayed");
        clickElements(search);
        wait(2000);
        sendkeys(searchBar,"India");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        wait(5000);

        scrollAndClickOnElement("23 hours ago");
        wait(5000);
        scrollAndClickOnElement("Latest");
    }
//    @BeforeClass
    public void startAppium()
    {
        new StartAppiumByCode().startServer();
    }
//    @AfterClass
    public void afterClass()
    {
        new StartAppiumByCode().stopServer();
    }
    getData data=new getData();
    @Test
    public void getdata1()
    {
       SetData name=data.getName1();
        System.out.println(name.getName());
    }
    @Test(description = "Check search functionality works fine")
    public void testScrollPageVertically(){
        String xpath = "//android.widget.TextView[@resource-id=\"com.google.android.apps.magazines:id/title\" and " +
                "@text=\"B2B AI applications better for revenue generation, B2C may take time: Shailesh Saraph of Tata Technologies\"]";
        base.restartApp();
        wait(3000);
        base.scrollPageVerticallyTillElementFound(xpath);
    }
    @Test(description = "Check search functionality works fine")
    public void testPageScrollHorizontally(){
        String text = "Health";
        wait(3000);
        base.restartApp();
        wait(3000);
        clickElements( "//*[@resource-id=\"com.google.android.apps.magazines:id/tab_ic_headlines\"]");
        wait(3000);
        base.scrollPageViewHorizontallyTillElementFound(text);
    }
    @Test(description = "Check search functionality works fine")
    public void testListScrollHorizontally(){
        String xpath = "//android.widget.TextView[@text=\"Health\"]";
        base.restartApp();
        wait(3000);
       clickElements( "//*[@resource-id=\"com.google.android.apps.magazines:id/tab_ic_headlines\"]");
        wait(3000);
        base.scrollTopList(xpath);
        clickElements( xpath);
    }

}
