package SeleniumHomeWork02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*
TC 1: Facebook dropdown verification
Open chrome browser
Go to "https://www.facebook.com"
click on create new account
Verify:
month dd has 12 month options
day dd has 31 day options
year dd has 115 year options
Select your date of birth
Quit browser
 */
public class HomeWork01 {

    public static String url="https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement newAcc = driver.findElement(By.partialLinkText("Create new account"));
        newAcc.click();
        Thread.sleep(1000);
        // =====================MONTH DD=================================
        WebElement month = driver.findElement(By.name("birthday_month"));
        Select monthSelect = new Select(month);
        List<WebElement> monthOption = monthSelect.getOptions();
        int monthSize = monthOption.size();
        if (monthSize == 12) {
            System.out.println("Verifying that month has 12 options");
        } else {
            System.out.println("Month doesn't have 12 months. Month has " + monthSize + " instead");
        }
        // ====================DAY DD=================================
        WebElement days = driver.findElement(By.id("day"));
        Select selectDays = new Select(days);
        List<WebElement> allOptionDays = selectDays.getOptions();
        int daySize = allOptionDays.size();
        if (daySize == 31) {
            System.out.println("Verifying that days has 31 : " + daySize);
        } else {
            System.out.println("Day does not have 31 days. Instead it has :" + daySize);
        }
        // ====================YEAR DD=================================
        WebElement year = driver.findElement(By.id("year"));
        Select yearSelect = new Select(year);
        List<WebElement> yearOption = yearSelect.getOptions();
        int sizeYear = yearOption.size();
        if (sizeYear == 115) {
            System.out.println("Year drop down has 115 years");
        } else {
            System.out.println("Year has : " + sizeYear);
        }
        // ================= SELECTING DATE OF BIRTH ====================
        yearSelect.selectByValue("1991");
        monthSelect.selectByVisibleText("Oct");
        selectDays.selectByIndex(2);

        driver.quit();
    }
}
