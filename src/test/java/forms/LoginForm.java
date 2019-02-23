package forms;

import newtest.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginForm extends BaseElement {
    private String xpathLoginTitle = "//*[contains(@class,'ui-dialog-title')][contains(@id,'ui-dialog-title-user-form')]";
    private String xpathEmailField = "//input[contains(@class,'email')]";
    private String xpathPasswordField = "//input[contains(@class,'password')]";
    private String xpathLoginButton = "//button[contains(@class,'button')]";

    public LoginForm() throws IOException {
    }

    /**
     * Checks by title that the login form is open.
     *
     * @return true - if login form is opened, false - if login form does not opened.
     */
    public boolean isLoginTitle(){
        WebElement loginTitle = driver.findElement(By.xpath(xpathLoginTitle));
        return loginTitle.isDisplayed();
    }

    /**
     * Set Email.
     *
     * @param email user Email.
     */
    public void setEmail(String email){
        WebElement emailField = driver.findElement(By.xpath(xpathEmailField));
        emailField.sendKeys(email);
    }

    /**
     * Set password.
     *
     * @param password user password.
     */
    public void setPassword(String password){
        WebElement passwordField = driver.findElement(By.xpath(xpathPasswordField));
        passwordField.sendKeys(password);
    }

    /**
     * Submit login button.
     */
    public void submitLogin(){
        WebElement loginButton = driver.findElement(By.xpath(xpathLoginButton));
        loginButton.click();
    }




}
