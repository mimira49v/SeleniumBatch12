package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {
    /*
    click on buttons and open new windows(tabs)
    switch to windows and perform different actions
     */
    public static String url= "https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageHandle = driver.getWindowHandle();
        WebElement igButton = driver.findElement(By.linkText("Follow On Instagram"));
        WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement igAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));
        igButton.click();
        fbButton.click();
        igAndFbButton.click();
        Set<String> allowWindowHandles = driver.getWindowHandles();
        System.out.println(allowWindowHandles.size());

        Iterator<String>it =allowWindowHandles.iterator();
        while(it.hasNext()){
            String handle = it.next(); // getting the next handle
            if(!mainPageHandle.equals(handle)){ // setting the condition
                driver.switchTo().window(handle);
                //driver.manage().window().maximize();
                    String title = driver.getTitle();
                        System.out.println(title);
                            driver.close();

            }
        }
        driver.switchTo().window(mainPageHandle); //switching back to parent handle
        igButton.click();
    }
}
