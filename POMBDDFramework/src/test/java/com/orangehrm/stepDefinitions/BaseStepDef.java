package com.orangehrm.stepDefinitions;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.reusableComponents.ConfigProperties;
import com.orangehrm.reusableComponents.CustomExceptionHandler;
import com.orangehrm.utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseStepDef {

    protected LoginPage loginPage;
    protected WebDriverWait wait;

    @Before
    public void init(){

        String sBrowser = ConfigProperties.getPropertyByKey("browser");
        String sUrl = ConfigProperties.getPropertyByKey("baseUrl");


        BrowserFactory browserFactory = BrowserFactory.getInstance();
        assert sBrowser != null;
        browserFactory.setDriver(browserFactory.initiateBrowser(sBrowser));
        WebDriver driver = browserFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(sUrl);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario){
        try {
            Thread.sleep(2000);
            final byte[] screenshot = ((TakesScreenshot) BrowserFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot_png");
        } catch (Exception e){
            CustomExceptionHandler.handleExceptions("Screenshot failed", e);
        }
    }

    @After
    public void tearDown(){
        BrowserFactory.getInstance().quitDriver();
    }
}
