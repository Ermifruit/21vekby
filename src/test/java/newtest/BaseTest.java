package newtest;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest extends BaseElement {
    private Logger log = Logger.getLogger(BaseTest.class);

    public BaseTest() throws IOException {
    }

    @BeforeTest
    public void startTest() throws IOException {
        log.info(String.format("Start the test for cross-browser testing on ======= %s =======", readProperties.getConfigProperty("nameBrowser")));
        long implicitTimeOut = Long.parseLong(readProperties.getConfigProperty("implicitTimeOut"));
        driver.manage().timeouts().implicitlyWait(implicitTimeOut, SECONDS);
        driver.manage().window().maximize();
        driver.get(projectUrl);
    }

    @AfterTest
    public void finishTest() throws IOException {
    createBrowserWebDriver.quitDriver();
    log.info(String.format("Finish Test on  %s", readProperties.getConfigProperty("nameBrowser")));
    }
}

