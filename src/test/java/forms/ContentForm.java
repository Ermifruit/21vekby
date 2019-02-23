package forms;

import newtest.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ContentForm extends BaseElement {
    private String xpathContentTitle = "//h1[contains(@class,'content__header')]";

    public ContentForm() throws IOException {
    }

    /**
     * Check that content form header contains subcategoryName.
     *
     * @param subcategoryName a subcategory from navigation menu.
     * @return true - if subcategory contains in title, false - if subcategory does not contain in title.
     */
    public boolean isContainsSubcategoryInTitle(String subcategoryName){
        WebElement contentTitle = driver.findElement(By.xpath(String.format(xpathContentTitle)));
        String title = contentTitle.getText();
        return title.contains(subcategoryName);
    }

    /**
     * Get the title of сontent form.
     *
     * @return Content title.
     */
    public String getContentTitle(){
        WebElement contentTitle = driver.findElement(By.xpath(String.format(xpathContentTitle)));
        return contentTitle.getText();
    }

}
