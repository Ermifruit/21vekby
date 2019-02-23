package forms;

import newtest.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class NavigationForm extends BaseElement {
    private String xpathNavigationMenu = "//*[contains(@class,'nav__list')]/*[contains(@class,'item')]";
    private String xpathNavigationItem =
            "//*[contains(@class,'nav__list')]/*[contains(@class,'item')]//*[contains(text(),'%s')]/../../*";
    private String xpathActiveNavigationItemAndBlock =
            "//*[contains(@class,'nav__list')]/*[contains(@style,'block')]/../*[contains(@class,'item')]" +
                    "[contains(@class,'active')]//*[contains(text(),'%s')]";
    private String xpathSubcategoryOfNavigationMenu = "//*[contains(@class,'nav__list')]//*[contains(@class,'nav-sub')]" +
            "//*[contains(@class,'nav-sub__link')][contains(text(),'%s')]";

    public NavigationForm() throws IOException {
    }

    /**
     * Select a category from navigation menu by itemName.
     *
     * @param itemName a category from navigation menu.
     * @throws IOException
     * @throws InterruptedException
     */
    public void openNavigationItem(String itemName) throws IOException, InterruptedException {
        threadSleep();
        WebElement navigationItem = driver.findElement(By.xpath(String.format(xpathNavigationItem,itemName)));
        fluentWait(navigationItem);
        navigationItem.click();
    }

    /**
     * Check the correct display of the selected category.
     *
     * @param itemName a category from navigation menu.
     * @return true - navigation menu is selected, false - navigation menu is not selected.
     */
    public boolean isActiveNavigationItemAndBlock(String itemName){
        WebElement activeNavigationItemAndBlock = driver.findElement(By.xpath(String.format(xpathActiveNavigationItemAndBlock,itemName)));
        return activeNavigationItemAndBlock.isDisplayed();

    }

    /**
     * Open subcategory of navigation menu.
     *
     * @param subcategoryName a subcategory from navigation menu.
     * @throws IOException
     * @throws InterruptedException
     */
    public void openSubcategoryofNavigationMenu(String subcategoryName) throws IOException {
        WebElement subcategoryOfNavigationsMenu = driver.findElement(By.xpath(String.format(xpathSubcategoryOfNavigationMenu,subcategoryName)));
        expliciteWait(subcategoryOfNavigationsMenu);
        subcategoryOfNavigationsMenu.click();
    }

}
