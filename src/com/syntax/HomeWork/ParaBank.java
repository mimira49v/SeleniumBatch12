package com.syntax.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
HW
navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
fill out the form
click on register
close the browser
 */
public interface ParaBank {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Milos");
        driver.findElement(By.id("customer.lastName")).sendKeys("Mileusnic");
        driver.findElement(By.id("customer.address.street")).sendKeys("Vojvodjanska");
        driver.findElement(By.id("customer.address.city")).sendKeys("Belgrade");
        driver.findElement(By.id("customer.address.state")).sendKeys("Florida");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("33401");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123456789");
        driver.findElement(By.id("customer.ssn")).sendKeys("0000000");
        WebElement username = driver.findElement(By.id("customer.username"));
        username.sendKeys("Milos");
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("password12345");
        driver.findElement(By.id("repeatedPassword")).sendKeys("123");
        Thread.sleep(2000);
        driver.findElement(By.className("button")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
