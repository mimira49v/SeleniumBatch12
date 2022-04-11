package com.syntax.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InternetHero {
    /*HW

    go to https://the-internet.herokuapp.com/dynamic_controls
    click on checkbox and click on remove
    verify the text
    click on enable verify the textbox is enabled
    enter text and click disable
    verify the textbox is disabled

     */

    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement checkBox = driver.findElement(By.xpath("//input[@type= 'checkbox']"));
        checkBox.click();

        WebElement button = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement text = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println(text.getText());

        Thread.sleep(1000);

        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement isEnabled = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println(isEnabled.getText());

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        textBox.sendKeys("MM");
        enableButton.click();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement disabled = driver.findElement(By.xpath("//p[@id='message']"));
        disabled.click();
        System.out.println(disabled.getText());

        driver.quit();
    }
}
