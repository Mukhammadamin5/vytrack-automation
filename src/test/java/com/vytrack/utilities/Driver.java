package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver webDriver;
    private Driver() {}

    public static WebDriver getDriver() {

        if (webDriver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("lang=en-GB");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(options);
                    webDriver.manage().window().maximize();
//                    webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    webDriver.manage().window().maximize();
//                    webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    break;
            }
//            webDriver.manage().window().maximize();
//            webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

        return webDriver;
    }

    public static WebDriver driver;

    //private static WebDriver getDriver(){};


    public static void closeDriver(){
        if (driver != null) {
            driver.quit(); // this will kill the session but driver will not be null
        }
    }
}