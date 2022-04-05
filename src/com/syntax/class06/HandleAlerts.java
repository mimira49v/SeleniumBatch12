package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

    /*
    Handle each and every alert on the page
     */


    public static String url = "http://uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        // Alert is an interface
        Alert simpleAlert = driver.switchTo().alert();   // switching the selenium focus on this alert
        Thread.sleep(2000);
        simpleAlert.accept(); //
        Thread.sleep(1000);

        WebElement confirmButton = driver.findElement(By.id("confirm"));
        Thread.sleep(1000);
        confirmButton.click();
        Alert confirmAlert = driver.switchTo().alert(); // Alert interface has get text method
        String alertText = confirmAlert.getText(); // storing alert text in a String
        Thread.sleep(1000);
        System.out.println(alertText);   // Printing sting alert text
        confirmAlert.dismiss();

        WebElement prompt = driver.findElement(By.cssSelector("button#prompt"));
        prompt.click();
        Thread.sleep(1000);
        Alert promptAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        promptAlert.sendKeys("Batch 12 is the best!!!");
        Thread.sleep(1000);
        promptAlert.accept();
    }
}
