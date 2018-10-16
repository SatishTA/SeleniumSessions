package src.SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverBasics {
    public static void main(String[] args) throws InterruptedException {
        //gecodriver for firefox
       /* System.setProperty("webdriver.gecko.driver", "D:\\Office BackUP\\Documents\\Selenium_Session\\geckodriver.exe");
        WebDriver driver= new FirefoxDriver();
        driver.get("https:\\www.gmail.com");*/

        //ChromeDriver for Chrome
        System.setProperty("webdriver.chrome.driver","D:\\Office BackUP\\Documents\\Selenium_Session\\chromedriver.exe");
        WebDriver driverc=new ChromeDriver();
        driverc.get("https:\\www.google.com");
        driverc.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(driverc.getTitle());
        //Thread.sleep(2000);
        driverc.findElement(By.xpath("//input[@type='text']")).sendKeys("Naveen Automation Labs");
        driverc.findElement(By.xpath("//input[@value='Google Search'] and type='submit'")).click();
    }
}
