package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JSExecutor_Color {

    public static String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//      login actions
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");

        JavascriptExecutor js = (JavascriptExecutor)driver;  // downcasting to JSExecutor to driver
        js.executeScript("arguments[0].style.backgroundColor='red'",username); // adding red color to field username
        js.executeScript("arguments[0].style.backgroundColor='green'",password);// adding red color to field password

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
//      loginButton.click();
        js.executeScript("arguments[0].click()",loginButton); // last option for clicking on the element!!!
    }
}
