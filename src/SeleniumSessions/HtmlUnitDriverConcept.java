package SeleniumSessions.PackageSeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class HtmlUnitDriverConcept {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Office BackUP\\Documents\\Sele_WorkSpace\\test\\target\\chromedriver.exe");
        //WebDriver driverc = new ChromeDriver();
        //HtmlUnitDriver is not part of selenium setup after 3.x onwards to use this
        // you need to download the jar file
        //Advantage of HtmlUnitDriver 1. fast execution 2. browser less testing 3. not suitable for action class like mouse movement, double click, drag and drop
        //4. called ghost driver, headless driver
       // available headless browser
        // HtmlUnitDriver --> based on java
        //PhantomJS --Javascript
        WebDriver driverc = new HtmlUnitDriver();
        driverc.manage().window().maximize();
        driverc.manage().deleteAllCookies();

        driverc.get("https://www.freecrm.com");
        driverc.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        System.out.println("Before Login Title is "+driverc.getTitle());
        Thread.sleep(3000);
        driverc.findElement(By.name("username")).sendKeys("naveenk");
        driverc.findElement(By.name("password")).sendKeys("test@123");

       driverc.findElement(By.xpath("//input[@type='submit']")).click();
       System.out.println("After Login Title is "+driverc.getTitle());
    }
}
