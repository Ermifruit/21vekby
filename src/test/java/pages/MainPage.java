package pages;

import forms.ContentForm;
import forms.LoginForm;
import forms.MyProfileForm;
import forms.NavigationForm;
import newtest.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class MainPage extends BaseElement {
    private String xpathMainLogo = "//h1[contains(@class,'logo')]";
    private String xpathLoginButton = "//*[contains(@class,'login')][contains(@title,'Вход')]";
    private String xpathMyProfileButton = "//*[contains(@class,'signed-in')]/*[contains(@class,'profile')]";
    private LoginForm loginForm = new LoginForm();
    private MyProfileForm myProfileForm = new MyProfileForm();
    private NavigationForm navigationForm = new NavigationForm();
    private ContentForm contentForm = new ContentForm();


    public MainPage() throws IOException {
    }

    /**
     * Check the logo display on the main page.
     *
     * @return true - if logo displayed , false - if logo does not displayed.
     */
    public boolean isMainLogo(){
        WebElement mainLogo = driver.findElement(By.xpath(xpathMainLogo));
        return mainLogo.isDisplayed();
    }

    /**
     * Opens login form.
     */
    public void openLoginForm(){
        WebElement loginButton = driver.findElement(By.xpath(xpathLoginButton));
        loginButton.click();
    }

    /**
     * Checks by title that the login form is open.
     *
     * @return true - if login form is opened, false - if login form does not opened.
     */
    public boolean isLoginFormTitle(){
        return loginForm.isLoginTitle();
    }

    /**
     * Authorization in the system.
     */
    public void login(){
        loginForm.setEmail(login);
        loginForm.setPassword(password);
        loginForm.submitLogin();
    }

    /**
     * Check the login button display on the main page.
     *
     * @return true - login button is displayed, false - if login button does not displayed.
     */
    public boolean isLoginButton(){
        WebElement loginButton = driver.findElement(By.xpath(xpathLoginButton));
        return loginButton.isDisplayed();
    }

    /**
     * Open the form of my profile.
     */
    public void openMyProfileForm(){
        WebElement myProfileButton = driver.findElement(By.xpath(xpathMyProfileButton));
        myProfileButton.click();
    }

    /**
     * Logout.
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void logout() throws IOException, InterruptedException {
        openMyProfileForm();
        myProfileForm.logout();
    }

    /**
     * Select a category from navigation menu by itemName.
     *
     * @param itemName a category from navigation menu.
     * @throws IOException
     * @throws InterruptedException
     */
    public void openNavigationItem(String itemName) throws IOException, InterruptedException {
        navigationForm.openNavigationItem(itemName);
    }

    /**
     * Check the correct display of the selected category.
     *
     * @param itemName a category from navigation menu.
     * @return true - navigation menu is selected, false - navigation menu is not selected.
     */
    public boolean isActiveNavigationItemAndBlock(String itemName){
        return navigationForm.isActiveNavigationItemAndBlock(itemName);
    }

    /**
     * Open subcategory of navigation menu.
     *
     * @param subcategoryName a subcategory from navigation menu.
     * @throws IOException
     * @throws InterruptedException
     */
    public void openSubcategoryofNavigationMenu(String subcategoryName) throws IOException, InterruptedException {
        navigationForm.openSubcategoryofNavigationMenu(subcategoryName);
    }

    /**
     * Check that content form header contains subcategoryName.
     *
     * @param subcategoryName a subcategory from navigation menu.
     * @return true - if subcategory contains in title, false - if subcategory does not contain in title.
     */
    public boolean isContainsSubcategoryInTitle(String subcategoryName){
        return contentForm.isContainsSubcategoryInTitle(subcategoryName);
    }

    /**
     * Get the title of сontent form.
     *
     * @return Content title.
     */
    public String getContentTitle(){
        return contentForm.getContentTitle();
    }
}
