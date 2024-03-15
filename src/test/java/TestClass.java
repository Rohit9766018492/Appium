import BaseLayer.AndroidBaseClass;
import BaseLayer.StartAppiumByCode;
import Utility.Listener;
import Utility.LoggerInfo;
import Utility.SetData;
import Utility.getData;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.locatorsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

@Listeners(Listener.class)
public class TestClass extends locatorsAndMethods {
    public static Logger logg= LogManager.getLogger(TestClass.class);
   @Test
    public void cal()
    {
        launchApp();
        logg.info("Application Launch");
//        changeOrientationToLandscape();
        wait(5000);
        mobileAlertHandle();
        Assert.assertTrue(isElementDisplay(googleNewsTitle),"Google title is not Displayed");
        logg.info("Google news title present");
//        log.info("Clicking on five button");
        Assert.assertTrue(isElementDisplay(search),"Plus is not Displayed");
        clickElements(search);
        wait(2000);
        sendkeys(searchBar,"India");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        wait(5000);

        scrollAndClickOnElement("23 hours ago");
        wait(5000);
        scrollAndClickOnElement("Latest");
    }
    @BeforeClass
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

}
