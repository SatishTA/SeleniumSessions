package SeleniumSessions.PackageSeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
Types of popups
1. alert- javascript popups we use alert api (accept(), dismiss())
2. fileupload pop up--browse button (type=file, sendkeys(path))
3. browse window popups --advertisment popups (windowhandler api-getWindowHandles()
 */
public class HandleWindowPopUps {

    public static <properties> void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Office BackUP\\Documents\\Selenium_Session\\chromedriver.exe");
        WebDriver driverc = new ChromeDriver();
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("D:\\Office BackUP\\Documents\\Selenium_Session\\src\\SeleniumSessions\\config.properties");
        prop.load(ip);
        driverc.get(prop.getProperty("poptesturl"));
        driverc.manage().window().maximize();
        driverc.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverc.findElement(By.xpath("//a[text()='Come & Go Test']")).click();
        Set<String> handle = driverc.getWindowHandles();
        Iterator<String> it = handle.iterator();
        String parentWindowId = it.next();
        System.out.println("Parent window id is" + parentWindowId);
        String childWindowId = it.next();
        System.out.println("Child window Id is " + childWindowId);
        driverc.switchTo().window(childWindowId);
        System.out.println("child window pop up title is " + driverc.getTitle());
        String pageTitle = driverc.getTitle();
        Thread.sleep(2000);
        pageTitle = pageTitle.substring(0, 9);
        System.out.println(pageTitle);
        if (pageTitle == "PopupTest") {
            System.out.println("Pop up window appeared");

        } else {
            System.out.println("please check the alert message");
        }
        driverc.close();
        driverc.switchTo().window(parentWindowId);
        System.out.println(driverc.getTitle());

    }
}
