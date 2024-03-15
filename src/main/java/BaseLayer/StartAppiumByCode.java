package BaseLayer;

import org.apache.logging.log4j.LogManager;
import org.example.locatorsAndMethods;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class StartAppiumByCode extends AndroidBaseClass{

    public  static Logger log= LogManager.getLogger(StartAppiumByCode.class);
@Test
    public void startServer() {
        log.info("---Starting Appium Server----");
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium");
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("---Stopping Appium Server----");
    }



}
