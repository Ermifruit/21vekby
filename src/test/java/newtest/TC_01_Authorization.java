package newtest;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.MainPage;

import java.io.IOException;

public class TC_01_Authorization extends BaseTest {
    private Logger log = Logger.getLogger(TC_01_Authorization.class);


    public TC_01_Authorization() throws IOException {
    }

    @Test
    public void TC_01_Authorization() throws IOException, InterruptedException {
        log.info(String.format("=====Step1===== The page \"%s\" is open",projectUrl));
        MainPage mainPage = new MainPage();
        softAssert.assertTrue(mainPage.isMainLogo(),"Main logo is absent");
        log.info("=====Step2===== Open login form");
        mainPage.openLoginForm();
        softAssert.assertTrue(mainPage.isLoginFormTitle(),"Login form is not opened");
        log.info("=====Step3===== Authorization");
        mainPage.login();
        softAssert.assertFalse(mainPage.isLoginButton(),"Authorization failed");
        log.info("=====Step4===== Logout");
        mainPage.logout();
        softAssert.assertTrue(mainPage.isLoginButton(),"Logout failed");

    }
}
