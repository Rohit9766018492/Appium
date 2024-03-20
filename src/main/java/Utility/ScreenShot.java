package Utility;

import BaseLayer.AndroidBaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends AndroidBaseClass
{
    public void takeScreenshot(String s)
    {
        TakesScreenshot ts=((TakesScreenshot) driver);


        File src=ts.getScreenshotAs(OutputType.FILE);

        String DateName=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        File des=new File("C:\\PROJECTS\\Appium\\src\\Screenshot\\"+s+"-"+DateName+"_screen.png");
        try {
            FileHandler.copy(src, des);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
