package src.SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class locatorsConcept {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Office BackUP\\Documents\\Selenium_Session\\chromedriver.exe");
        WebDriver driverc=new ChromeDriver();
        driverc.get("https://smartrip.wmata.com");
        driverc.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(driverc.getTitle());
        //Thread.sleep(2000);
        //driverc.quit();
        driverc.findElement(By.xpath("//input[@title='Enter your user name']")).sendKeys("satish_l");
        driverc.findElement(By.xpath("//input[@alt=\"Password\"]")).sendKeys("Satya08@u");
        driverc.findElement(By.xpath("//input[@title='Login']")).click();
        driverc.findElement(By.xpath("//a[@class='LogoutLink']")).click();
        System.out.println("Log out sucessfull");

    }
}
