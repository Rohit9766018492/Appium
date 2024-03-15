package BaseLayer;

import Utility.LoggerInfo;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseClass {

    public static AndroidDriver driver;
    public static Logger log;

    public static Properties pro;
    public AndroidBaseClass()
    {
        pro=new Properties();
        try {
            InputStream fis = new FileInputStream("C:\\PROJECTS\\Appium\\src\\main\\java\\ConfigFile\\config.properties");
            pro.load(fis);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void launchApp()
    {
        log= LogManager.getLogger(LoggerInfo.class);

        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        String deviceName=pro.getProperty("deviceName");
        System.out.println("Device Name --->" +deviceName);

        if(deviceName.contains("Pixel 6 Pro - MA1925"))
        {
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 Pro - MA1925");
            dc.setCapability(MobileCapabilityType.UDID, "1C091FDEE0095R");
        }
        else if (deviceName.contains("Pixel 5"))
        {
           dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 5");
            dc.setCapability(MobileCapabilityType.UDID,"16051FDD4003FJ");
        }
        else if (deviceName.contains("Galaxy A31"))
        {
            dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy A31");
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
            dc.setCapability(MobileCapabilityType.UDID,"RZ8N821XZLJ");
        }

        dc.setCapability("appPackage",pro.getProperty("appPackage"));
        dc.setCapability("appActivity",pro.getProperty("appActivity"));
//        dc.setCapability(MobileCapabilityType.NO_RESET,true);
//        dc.setCapability("autoAcceptAlerts",true);


        try {
            URL url = new URL("http://0.0.0.0:4723");

            driver = new AndroidDriver(url, dc);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        log.info("App is open");
    }
    public void wait(int time)
    {try {
        log.info("Wait for "+time);
        Thread.sleep(time);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    }

    public void clickWebElements(String Locator)
    {
        WebElement element=driver.findElement(By.xpath(Locator));
        element.click();
        System.out.println("Click on web element");

    }
    public void changeOrientationToLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    public void changeOrientationToPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void changeOrientation()
    {
        String orintation= String.valueOf(driver.getOrientation());
        if(orintation.equalsIgnoreCase("landscape"))
        {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
        driver.runAppInBackground(Duration.ofSeconds(10));

    }

}
