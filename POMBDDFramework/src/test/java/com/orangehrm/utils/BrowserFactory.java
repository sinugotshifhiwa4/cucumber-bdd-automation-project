package com.orangehrm.utils;

import com.orangehrm.reusableComponents.CustomExceptionHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    private static final BrowserFactory instance = new BrowserFactory();
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private BrowserFactory() {}

    public static BrowserFactory getInstance() {
        return instance;
    }

    public void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public WebDriver initiateBrowser(String browserName) {

        switch (browserName.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                setDriver(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                setDriver(new FirefoxDriver(firefoxOptions));
                break;

            case "msedge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                setDriver(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browserName);
        }

        return getDriver();
    }

    public void navigateToUrl(String url) {
        getDriver().navigate().to(url);
    }

    public void quitDriver(){

        try{
            WebDriver driver = threadLocalDriver.get();

            if(driver != null){
                Thread.sleep(4000);
                driver.quit();
            }

        } catch (Exception e){
            CustomExceptionHandler.handleExceptions("Quitting driver", e);
        } finally {
            threadLocalDriver.remove();
        }
    }
}
