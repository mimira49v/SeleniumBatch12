package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDocuments {

    public static String url = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement findFileUpload = driver.findElement(By.linkText("File Upload"));
        findFileUpload.click();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\mileu\\OneDrive\\Desktop\\Test.xls");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
    }
}
