package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarHandling {
    /*

    navigating to delta
    and choosing departure
    and return dates
     */

    public static String url = "http://delta.com";

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
        calendar.click();

        WebElement nextButton = driver.findElement(By.xpath("//span[text() = 'Next']"));
        WebElement dMonth = driver.findElement(By.className("dl-datepicker-month-0"));
        String dMontText = dMonth.getText();

        while(!dMontText.equals("August")){
            nextButton.click();
            dMontText = dMonth.getText();
        }

        List<WebElement> deparDates = driver.findElements(By.xpath(" //tbody[@class='dl-datepicker-tbody-0']/tr/td"));
        for (WebElement departDate:deparDates) {
            if(departDate.getText().equals("13")){
                departDate.click();
                break;
            }
        }
        WebElement rMonth = driver.findElement(By.className("dl-datepicker-month-1"));
        String rMonthText = rMonth.getText();

        while(!rMonthText.equals("November")){
            nextButton.click();
            rMonthText = rMonth.getText();
        }

        List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
        for (WebElement returnDate:returnDates) {
            if(returnDate.getText().equals("30")){
                returnDate.click();
                break;
            }
        }

        WebElement doneButton = driver.findElement(By.className("doneButton"));
        doneButton.click();
    }
}
