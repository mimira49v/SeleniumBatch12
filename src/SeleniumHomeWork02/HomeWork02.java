package SeleniumHomeWork02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
HW1
Go to facebook sign up page
Fill out the whole form
Click signup
 */
public class HomeWork02 {

    public static String url="https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement newAcc = driver.findElement(By.partialLinkText("Create new account"));
        newAcc.click();

        // First name
        Thread.sleep(1000);
        WebElement name = driver.findElement(By.xpath("//input[@name='firstname']"));
        name.sendKeys("Roki");
        Thread.sleep(1000);

        // Last name
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Balboa");
        Thread.sleep(1000);

        // Email
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("email@gmail.com");
        Thread.sleep(1000);

        // Email confirmation
        WebElement email_confirmation = driver.findElement(By.name("reg_email_confirmation__"));
        email_confirmation.sendKeys("email@gmail.com");
        Thread.sleep(1000);

        // Password
        WebElement password = driver.findElement(By.id("password_step_input"));
        password.sendKeys("mksdfs123");
        Thread.sleep(2000);

        // Month
        WebElement month = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("Oct");

        // Day
        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("2");
        WebElement year = driver.findElement(By.id("year"));

        // Year
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1991");
        driver.findElement(By.xpath("//input[@value='2']")).click();

        // Submit
        WebElement submit = driver.findElement(By.name("websubmit"));
        Thread.sleep(2000);
        submit.click();
    }
}
