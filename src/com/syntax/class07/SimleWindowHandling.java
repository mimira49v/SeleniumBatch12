package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimleWindowHandling {
    /*
    click on help link
    switch between tabs
     */
    public static String url = "http://accounts.google.com/signup";

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            //get the handle of this specific window: it will return  the ID of that specific tab
            String mainPageHandle = driver.getWindowHandle();
            System.out.println(mainPageHandle); //ID printed in console

            //click on help link and switch to a different window:
            WebElement helpLink = driver.findElement(By.linkText("Help"));
            helpLink.click();

            //now we have two tabs, and we got all the handles and stored them in a set.
            Set<String> allWindowHandles = driver.getWindowHandles(); //using set because line 23 will provide multiple tabs
            //get the count inside the set
            System.out.println(allWindowHandles.size());
            //now we have two tabs open, two tabs in our windows set

            //start going through these 2 tabs: create an iterator two iterate through the window handles
            Iterator<String> it = allWindowHandles.iterator();
            mainPageHandle=it.next(); //mainPageHandle is the string we previousely declared
            //we have two tabs so we make 2moves , two steps forward , 2 it.next
            String childHandle = it.next(); //this is the child handle / parent is on line 20.
            System.out.println(childHandle);//get the second ID, second tab child handle

            //switch to the window: specify the handle where u want to switch, in this case switch to main page
            driver.switchTo().window(childHandle);

            Thread.sleep(2000);
            driver.close();
            driver.switchTo().window(mainPageHandle);
            helpLink.click();
        }
    }
