package Utility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends ScreenShot implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("<<-----Test case Start----->>"+iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("<<-----Test case Success----->>"+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("<<-----Test case Failure----->>"+iTestResult.getName());
        takeScreenshot();
        changeOrientation();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("<<-----Test case Skipped----->>"+iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("<<-----Test case Start 2222----->>"+iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("<<-----Test case Finish----->>"+iTestContext.getName());
    }
}
