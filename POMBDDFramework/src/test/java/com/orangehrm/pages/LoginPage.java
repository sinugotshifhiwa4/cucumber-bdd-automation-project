package com.orangehrm.pages;

import com.orangehrm.reusableComponents.BaseActions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseActions {

    WebDriver driver;

    @FindBy(css = "input[name='username']")
    private WebElement usernameTextBox;

    @FindBy(css = "input[name='password']")
    private WebElement passwordTextBox;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "div[class='oxd-alert-content oxd-alert-content--error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardTab;

    @FindBy(css = "img[alt='company-branding']")
    private WebElement orangehrmLogo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String username) {
        clearElement(usernameTextBox, "fillUsername");
        fillElement(usernameTextBox, "fillUsername", username);
    }

    public void fillPassword(String password) {
        clearElement(passwordTextBox, "fillPassword");
        fillElement(passwordTextBox, "fillPassword", password);
    }

    public void clickLogin() {
        clickElement(loginButton, "clickLogin");
    }

    public void verifyDashboardTabIsVisible() {
        verifyElementIsVisible(dashboardTab, "verifyDashboardTabIsVisible");
    }

    public void verifyOrangehrmLogoIsVisible() {
        verifyElementIsVisible(orangehrmLogo, "verifyOrangehrmLogoIsVisible");
    }

    public void verifyErrorMessageIsVisible() {
        verifyElementIsVisible(errorMessage, "verifyErrorMessageIsVisible");
    }

    public void verifyErrorMessageIsNotVisible() {
        verifyElementIsNotVisible(errorMessage, "verifyErrorMessageIsNotVisible");
    }

    public void loginToOrangehrm(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLogin();
    }

    public WebElement getErrorMessageElement(){
        return errorMessage;
    }

    public WebElement getDashboardTabElement(){
        return dashboardTab;
    }

    public WebElement getOrangehrmLogoElement(){
        return orangehrmLogo;
    }
}
