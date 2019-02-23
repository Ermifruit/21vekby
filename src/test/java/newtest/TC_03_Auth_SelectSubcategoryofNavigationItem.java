package newtest;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;

import java.io.IOException;

public class TC_03_Auth_SelectSubcategoryofNavigationItem extends BaseTest {
    private Logger log = Logger.getLogger(TC_03_Auth_SelectSubcategoryofNavigationItem.class);
    private MainPage mainPage = new MainPage();

    public TC_03_Auth_SelectSubcategoryofNavigationItem() throws IOException {
    }

    @DataProvider
    public Object[][] testSelectSubcategoryofNavigationItem(){
        return new Object[][]{
                {"Для кухни", "Крупная техника"},
                {"Для кухни", "Встраиваемая техника, оборудование"},
                {"Для кухни", "Мелкая техника"},
                {"Для кухни",  "Мебель для кухни"},
                {"Для кухни", "Посуда, кухонная утварь"},
                {"Для дома", "Бытовая техника"},
                {"Для дома", "Климат"},
                {"Для дома", "Интерьер"},
                {"Для дома", "Для ванной"},
                {"Для дома", "Мебель для жилых комнат"},
                {"Для дома", "Мебель для прихожей"},
                {"Для дома", "Мебель для спальни"},
                {"Для дома", "Мягкая мебель"},
                {"Для дома", "Мебель для кухни"},
                {"Для дома", "Хозтовары, бытовая химия"},
                {"Для дома", "Товары для животных"},
                {"Электроника", "ТВ, видео"},
                {"Электроника", "Аудиотехника"},
                {"Электроника", "Портативные устройства"},
                {"Электроника", "Музыкальные инструменты, оборудование"},
                {"Электроника", "Гаджеты, подарки"},
                {"Электроника", "Фото, видеосъемка"},
                {"Для ремонта", "Сантехника"},
                {"Для ремонта", "Отопление, водоснабжение, вентиляция"},
                {"Для ремонта", "Двери и конструкции для дома"},
                {"Для ремонта", "Электроинструмент"},
                {"Для ремонта", "Профессиональный инструмент"},
                {"Для ремонта", "Ручной инструмент, аксессуары"},
                {"Для ремонта", "Строительное оборудование"},
                {"Для ремонта", "Крепежные изделия"},
                {"Для ремонта", "Отделочные материалы"},
                {"Для ремонта", "Электрооборудование"},
                {"Компьютеры", "Компьютерная техника"},
                {"Компьютеры", "Периферия, аксессуары"},
                {"Компьютеры", "Комплектующие"},
                {"Компьютеры", "Печать, дизайн"},
                {"Компьютеры", "Сетевое оборудование"},
                {"Офис", "Товары для офиса"},
                {"Офис", "Мебель для офиса"},
                {"Офис", "Торговля, склад"},
                {"Дача, сад", "Садовая техника, инвентарь"},
                {"Дача, сад", "Оборудование"},
                {"Дача, сад", "Для отдыха"},
                {"Дача, сад", "Обустройство участка"},
                {"Дача, сад", "Товары для бани"},
                {"Авто", "Запчасти и технические жидкости"},
                {"Авто", "Автобезопасность"},
                {"Авто", "Автоэлектроника"},
                {"Авто", "Автозвук и видео"},
                {"Авто", "Оборудование для авто"},
                {"Спорт", "Активный отдыхо"},
                {"Спорт", "Фитнес"},
                {"Спорт", "Туризм"},
                {"Спорт", "Охота и рыбалка"},
                {"Красота", "Товары для красоты и здоровья"},
                {"Красота", "Гигиенические средства"},
                {"Красота", "Уход за лицом"},
                {"Красота", "Декоративная косметика"},
                {"Красота", "Уход за телом"},
                {"Красота", "Уход за волосами"},
                {"Красота", "Маникюр, педикюр"},
                {"Красота", "Парфюмерия"},
                {"Красота", "Стиль"},
                {"Детям", "Мебель и комфорт"},
                {"Детям", "Товары для прогулок"},
                {"Детям", "Гигиена и уход"},
                {"Детям", "Товары для мам"},
                {"Детям", "Товары для самых маленьких"},
                {"Детям", "Игрушки"},
                {"Детям", "Творчество, хобби"},
        };
    }

    @BeforeClass
    public void TC_03_Auth_SelectSubcategoryofNavigationItem_Precondition(){
        log.info(String.format("=====Step1===== The page \"%s\" is open",projectUrl));
        softAssert.assertTrue(mainPage.isMainLogo(),"Main logo is absent");
        log.info("=====Step2===== Open login form");
        mainPage.openLoginForm();
        softAssert.assertTrue(mainPage.isLoginFormTitle(),"Login form is not opened");
        log.info("=====Step3===== Authorization");
        mainPage.login();
        softAssert.assertFalse(mainPage.isLoginButton(),"Authorization failed");
    }

    @Test(dataProvider = "testSelectSubcategoryofNavigationItem")
    public void TC_03_Auth_SelectSubcategoryofNavigationItem(String itemName, String subcategoryName) throws IOException, InterruptedException {
        log.info(String.format("=====Step4===== Select navigation item and check -> %s", itemName));
        mainPage.openNavigationItem(itemName);
        softAssert.assertTrue(mainPage.isActiveNavigationItemAndBlock(itemName), "Navigation item is not selected");
        log.info(String.format("=====Step5===== Select subcategory of navigation menu -> %s", subcategoryName));
        mainPage.openSubcategoryofNavigationMenu(subcategoryName);
        softAssert.assertTrue(mainPage.isContainsSubcategoryInTitle(subcategoryName),
                String.format("Content title is wrong and equals %s ", mainPage.getContentTitle()));
    }

    @AfterClass
    public void TC_03_Auth_SelectSubcategoryofNavigationItem_Postcondtion() throws IOException, InterruptedException {
        log.info("=====Step5===== Logout");
        mainPage.logout();
        softAssert.assertTrue(mainPage.isLoginButton(),"Logout failed");
    }
}
