package com.syntax.review04.notes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class windowsHandle {

    public static String url = "https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//            find all the buttons that open up new windows or tabs
        WebElement helpBtn = driver.findElement(By.xpath("//a[text()='Help']"));
        WebElement privacyBtn = driver.findElement(By.xpath("//a[text()='Privacy']"));
        WebElement termsBtn = driver.findElement(By.xpath("//a[text()='Terms']"));

//            clicking on the btns
        helpBtn.click();
        privacyBtn.click();
        termsBtn.click();
//            get the main page handle
        String mainPageHandle = driver.getWindowHandle();
        System.out.println("The handle is : "+mainPageHandle);

//      storing all handles in a set
        Set<String> allHandles = driver.getWindowHandles();
//      iterating through all handles
        Iterator<String> it = allHandles.iterator();
        while(it.hasNext()){
            String handle = it.next();
            if(!mainPageHandle.equals(handle)){
//              switch to the new tab
                driver.switchTo().window(handle);
//              check if it is the desired tab
                String title = driver.getTitle();
                if(title.equalsIgnoreCase("Privacy Policy – Privacy & Terms – Google"))

                System.out.println("Hurray you are on the right page i.e Privacy and terms");
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());
                break;
            }
        }
    }
}
