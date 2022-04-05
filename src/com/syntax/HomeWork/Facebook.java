package com.syntax.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Facebook {
    public static void main(String[] args) throws InterruptedException {
/*
    Navigate to fb.com
    click on create new account
    fill up all the text-boxes
    click on sign up button
    close the pop-up
    close the browser
 */
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Nikola");
        Thread.sleep(1000);
        driver.findElement(By.name("lastname")).sendKeys("Skrbic");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_email__")).sendKeys("nikola@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("nikola@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("nikola123");
        Thread.sleep(1000);
        driver.findElement(By.id("month")).sendKeys("October");
        Thread.sleep(1000);
        driver.findElement(By.name("birthday_day")).sendKeys("6");
        Thread.sleep(1000);
        driver.findElement(By.name("birthday_year")).sendKeys("1991");
        Thread.sleep(1000);
        driver.findElement(By.name("sex")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
