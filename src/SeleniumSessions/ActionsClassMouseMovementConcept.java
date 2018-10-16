package src.SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionsClassMouseMovementConcept {
    public static void main(String[] args) {
        String expectedTite="Flight Bookings: Book Air Tickets, Flight Tickets Online | Jet Airways";
        System.setProperty("webdriver.chrome.driver","target/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.jetairways.com/en/us/planyourtravel/book-flight-tickets-online.aspx");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Actions action= new Actions(driver);

        System.out.println(driver.getTitle());
        String actualTitle=driver.getTitle();
        if(actualTitle.equalsIgnoreCase(expectedTite)){
            System.out.println("Title matched");
            //driver.findElement(By.linkText("planyourtravel")).click();
            action.moveToElement(driver.findElement(By.linkText("PLAN YOUR TRAVEL"))).build().perform();
            driver.findElement(By.linkText("Book Flight Tickets Online")).click();
            System.out.println(driver.getTitle());
        }
        else {
            System.out.println("Title is not matched");
            }
    }
}
