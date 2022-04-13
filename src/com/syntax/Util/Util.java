package com.syntax.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
Create functions (methods) to open close and quit the browsers
open method has to accept an url as a parametar
 */
public class Util {
    public static WebDriver driver;

    public static void openBrowser(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public static void closeBrowser(){
        if(driver!=null){
            driver.close();
        }
    }
    public static void quitBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }
}
