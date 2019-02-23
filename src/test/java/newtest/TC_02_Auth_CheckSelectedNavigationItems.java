package newtest;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;

import java.io.IOException;

public class TC_02_Auth_CheckSelectedNavigationItems extends BaseTest{
    private Logger log = Logger.getLogger(TC_02_Auth_CheckSelectedNavigationItems.class);

    public TC_02_Auth_CheckSelectedNavigationItems() throws IOException {
    }

    @DataProvider
    public Object[][] testDataForSelectedNagitionsItems() {
        return new Object[][]{
                {"Для кухни"},
                {"Для дома"},
                {"Для ремонта"},
                {"Электроника"},
                {"Компьютеры"},
                {"Офис"},
                {"Дача, сад"},
                {"Авто"},
                {"Спорт"},
                {"Красота"},
                {"Детям"}
        };
    }

    @Test(dataProvider = "testDataForSelectedNagitionsItems")
    public void TC_02_Auth_CheckSelectedNavigationItems(String itemName) throws IOException, InterruptedException {
        log.info(String.format("=====Step1===== The page \"%s\" is open",projectUrl));
        MainPage mainPage = new MainPage();
        softAssert.assertTrue(mainPage.isMainLogo(),"Main logo is absent");
        log.info("=====Step2===== Open login form");
        mainPage.openLoginForm();
        softAssert.assertTrue(mainPage.isLoginFormTitle(),"Login form is not opened");
        log.info("=====Step3===== Authorization");
        mainPage.login();
        softAssert.assertFalse(mainPage.isLoginButton(),"Authorization failed");
        log.info(String.format("=====Step4===== Select navigation item and check -> %s", itemName));
        mainPage.openNavigationItem(itemName);
        softAssert.assertTrue(mainPage.isActiveNavigationItemAndBlock(itemName), "Navigation item is not selected");
        log.info("=====Step5===== Logout");
        mainPage.logout();
        softAssert.assertTrue(mainPage.isLoginButton(),"Logout failed");
    }


}
