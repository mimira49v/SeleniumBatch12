package com.syntax.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*
HW
Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
click on leave
click on leave list
choose from "From calendar"
choose from "To calendar"
click only on cancelled and rejected checkboxes
uncheck Pending Approval
select IT support from DD
click search
quit the browser
 */

public class CalendarHomeWork {

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        WebElement leaveList = driver.findElement(By.id("menu_leave_viewLeaveList"));
        leaveList.click();
        WebElement from=driver.findElement(By.id("calFromDate"));
        from.click();
        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(monthDD);
        select.selectByValue("6");
        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement fromDate: fromDates) {
            String dateText = fromDate.getText();
            if(dateText.equals("1")) {
                fromDate.click();
                break;
            }
        }
        WebElement toDate=driver.findElement(By.id("calToDate"));
        toDate.click();
        WebElement monthDD2 = driver.findElement(By.className("ui-datepicker-month"));
        monthDD2.click();;
        Select select2 = new Select(monthDD2);
        select2.selectByValue("6");
        List<WebElement> todates=driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement todate:todates){
            if(todate.getText().equals("8")){
                todate.click();
                break;
            }
        }
        driver.findElement(By.cssSelector("#leaveList_chkSearchFilter_-1")).click();
        driver.findElement(By.cssSelector("#leaveList_chkSearchFilter_0")).click();
        driver.findElement(By.cssSelector("#leaveList_chkSearchFilter_1")).click();
        WebElement it=driver.findElement(By.xpath("//select[@name='leaveList[cmbSubunit]']"));
        Select select3=new Select(it);
        select3.selectByValue("2");
        driver.findElement(By.xpath("//input[@name='btnSearch']")).click();
        driver.quit();
    }
}
