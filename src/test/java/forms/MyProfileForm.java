package forms;

import newtest.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class MyProfileForm extends BaseElement {
    private String xpathLogoutLink = "//*[contains(@class,'submenu')]//*[contains(@rel,'nofollow')][contains(text(),'Выход')]";

    public MyProfileForm() throws IOException {
    }

    /**
     * Logout.
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void logout() throws IOException, InterruptedException {
        WebElement logoutButton = driver.findElement(By.xpath(xpathLogoutLink));
        fluentWait(logoutButton);
        logoutButton.click();
    }

}
