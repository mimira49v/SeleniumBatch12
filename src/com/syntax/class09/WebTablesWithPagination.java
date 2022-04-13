package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesWithPagination {

    public static String url = "http://syntaxprojects.com/table-pagination-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));
        WebElement nextButton = driver.findElement(By.xpath("//a[@class='next_link']"));
        boolean flag = true;

        while(flag){
            for (WebElement r:rows) {
                String rowText = r.getText();
                if(rowText.contains("Archy J")){
                    // false is needed here so the iteration doesn't continue
                    flag = false;
                    System.out.println(rowText);
                    break;
                }
            }
            if(flag) {
                nextButton.click();
            }
        }
    }
}
