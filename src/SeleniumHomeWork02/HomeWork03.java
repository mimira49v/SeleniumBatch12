package SeleniumHomeWork02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*
HW2
Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header
 */
public class HomeWork03 {
    public static String url="https://www.ebay.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement categories = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categories);

        List <WebElement> options = select.getOptions();
        for(WebElement option:options){
            String text = option.getText();
            System.out.println(text);
        }

        WebElement search = driver.findElement(By.id("gh-btn"));
        select.selectByValue("58058");
        search.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//span[@class=\"b-pageheader__text\"]"));
        boolean displayed = header.isDisplayed();
        if(displayed){
            System.out.println("Driver is displayed = "+displayed);
        }else {
            System.out.println("Header is NOT displayed!");
        }
        driver.close();


    }
}
