package src.SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.Credentials;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

public class AlertPopUpHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Office BackUP\\Documents\\Selenium_Session\\chromedriver.exe");
        WebDriver driverc=new ChromeDriver();
        driverc.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driverc.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(driverc.getTitle());
        //Thread.sleep(2000);
        //driverc.quit();
        driverc.findElement(By.name("proceed")).click();
        Alert alert=driverc.switchTo().alert();
        System.out.println("Pop alert message received"+alert.getText());
        String text=alert.getText();
        if(text.equals("Please enter a valid user name")) {
            System.out.println("correct alert message received");
            alert.accept();//click on Ok to close alert
        }else
        {
            System.out.println("please check the alert message");
        }

        //alert.dismiss();//to dismiss the alert

    }
}
