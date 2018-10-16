package src.SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragDropconcept {
    public static void main(String[] args) {
        String expectedTite="Flight Bookings: Book Air Tickets, Flight Tickets Online | Jet Airways";
        System.setProperty("webdriver.chrome.driver","target/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("   http://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.switchTo().frame(0);
        System.out.println(driver.getTitle());
        Actions action= new Actions(driver);
        action.clickAndHold(driver.findElement(By.id("draggable")))
                .moveToElement(driver.findElement(By.id("droppable")))
                .release()
                .build()
                .perform();
    //Xpath concept
        /*dynamic id
                id="456";
                id="789";
          starts with
                id="test_13"
                id="test_456"
                id="test_789"
          Ends with
                id="123_test"
                id="789_test"
                        */
        driver.findElement(By.xpath("//input[contains(@id,'test')]")).sendKeys("java");
        driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("java");
        driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("java");
    }

}
