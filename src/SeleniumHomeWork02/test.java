package SeleniumHomeWork02;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class test {

        public static String url = "http://www.uitestpractice.com/Students/Contact";

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(url);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            WebElement ajaxLink = driver.findElement(By.linkText("This is Ajax link"));
            ajaxLink.click();

            WebElement contact = driver.findElement(By.cssSelector("div.ContactUs"));
            String contactText = contact.getText();
            System.out.println(contactText);

        }
}

