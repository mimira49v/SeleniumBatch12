package com.syntax.review03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class frames {

    public static String url = "https://chercher.tech/practice/frames";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
//
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame(0);
        WebElement topic = driver.findElement(By.xpath("//b[@id='topic']"));
        System.out.println(topic.getText());
//      switching to default content
        driver.switchTo().defaultContent();
//      switching to second frame
        driver.switchTo().frame(1);
//      locating drop down menu
        WebElement dropDown = driver.findElement(By.tagName("select"));
//      selecting second element from drop down
        Select select = new Select(dropDown);
        select.selectByIndex(2);

        driver.switchTo().defaultContent();

//      driver.switchTo().frame(0);
//      locating frame 1
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame1);

        driver.switchTo().frame("frame3");
        driver.findElement(By.xpath("//input[@id='a']")).click();
    }
}
