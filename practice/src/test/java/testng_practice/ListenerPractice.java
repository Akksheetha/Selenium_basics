package testng_practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerPractice implements ITestListener {

    private static final Logger logger = LogManager.getLogger(ListenerPractice.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getName());
        logger.error("Reason: ", result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: " + result.getName());
    }
}