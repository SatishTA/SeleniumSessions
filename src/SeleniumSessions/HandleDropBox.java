package src.SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandleDropBox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Office BackUP\\Documents\\Selenium_Session\\chromedriver.exe");
        WebDriver driverc=new ChromeDriver();
        driverc.get("https://www.riamoneytransfer.com/price-calculator");
        driverc.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(driverc.getTitle());
        Select select=new Select(driverc.findElement(By.id("countriesDDL")));
        select.selectByVisibleText("India");
        driverc.findElement(By.xpath("//span[text()='Bank Account']")).isSelected();
    //Thread.sleep(2000);
        //driverc.quit();


    }
}
