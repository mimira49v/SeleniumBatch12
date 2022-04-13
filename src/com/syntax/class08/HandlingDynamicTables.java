package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingDynamicTables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        // Login information and click
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.className("button"));
        loginButton.click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr"));
        for (int i = 1; i < rows.size(); i++) {
            String rowText = rows.get(i).getText();
            System.out.println(rowText);
            // If it matches the string Bob Feather passes the brackets
            if(rowText.contains("Bob Feather")){
                List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr/td[1]"));
                // needs to have one element that's why we using " get(i) "
                // get(i-1) is because we are starting from 1 and not from 0
                // That's how we can get an object 0 in the header
                checkBoxes.get(i-1).click();
            }
        }
    }
}
