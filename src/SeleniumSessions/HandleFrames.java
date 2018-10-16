package src.SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandleFrames {
    public static void main(String[] args) {
       String expectedTite="CRMPRO";
        System.setProperty("webdriver.chrome.driver","target/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("https://www.freecrm.com/index.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.name("username")).sendKeys("naveenk");
        driver.findElement(By.name("password")).sendKeys("test@123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println(driver.getTitle());
       String actualTitle=driver.getTitle();
       if(actualTitle.equalsIgnoreCase(expectedTite)){
           System.out.println("Title matched");
           driver.switchTo().frame("mainpanel");
           driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
       }
       else {
           System.out.println("Title is not matched");
       }
        }






    }

