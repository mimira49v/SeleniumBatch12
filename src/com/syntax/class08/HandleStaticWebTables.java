package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandleStaticWebTables {

    public static String url = "http://syntaxprojects.com/table-search-filter-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        System.out.println("=================ROWS========================");

        List<WebElement> rowData = driver.findElements(By.xpath("//table[@id = 'task-table']/tbody/tr"));
        System.out.println(rowData.size());

        Iterator<WebElement> it = rowData.iterator();
        while(it.hasNext()){
            WebElement row = it.next();
                String rowText = row.getText();
                    System.out.println(rowText);
        }

        System.out.println("=================HEADER========================");

        List<WebElement> columnData = driver.findElements(By.xpath("//table[@id = 'task-table']/thead/tr/th"));
        System.out.println(columnData.size());

        for (WebElement columData:columnData) {
            String columText = columData.getText();
                System.out.println(columText);
        }
    }
}
