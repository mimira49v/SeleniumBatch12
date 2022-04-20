package com.syntax.SeleniumHomeWork04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    /*
    HW
Go to aa.com/homePage.do
select depart date
select return date
select destination
click on search
quit the browser
     */

    public static String url = "https://aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement calendar = driver.findElement(By.className("ui-datepicker-trigger"));
        calendar.click();

        WebElement nextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
        WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
        String monthText = month.getText();

        while(!monthText.equals("June")){
            nextButton.click();
            month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            monthText = month.getText();
            nextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
        }
        List<WebElement> departure = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement departureDates:departure) {
            if(departureDates.getText().equals("8")){
                departureDates.click();
                Thread.sleep(1000);
                break;
            }
        }
        WebElement arrivalCal = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
        arrivalCal.click();
        WebElement nextButton2 = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
        WebElement arrivalMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
        WebElement day = driver.findElement(By.xpath("//body[1]/div[8]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/a[1]"));
        String dayText = day.getText();
        String arrivalMonthText = arrivalMonth.getText();
        WebElement returnDay = driver.findElement(By.xpath("//body[1]/div[8]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/a[1]"));
        String returnDayText = returnDay.getText();


        List<WebElement> arrival = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement arrivalDates:arrival) {
            if(arrivalDates.getText().equals("10")){
                arrivalDates.click();
                break;
            }
        }
        System.out.println(monthText+" "+dayText);
        System.out.println(arrivalMonthText+" "+returnDayText);
    }
}
