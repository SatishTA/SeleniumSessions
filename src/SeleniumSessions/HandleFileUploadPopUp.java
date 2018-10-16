package src.SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HandleFileUploadPopUp {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Office BackUP\\Documents\\Selenium_Session\\chromedriver.exe");
        WebDriver driverc=new ChromeDriver();
        driverc.manage().window().maximize();
        driverc.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverc.get("https://html.com/input-type-file/");
        Thread.sleep(20000);
        driverc.findElement(By.xpath("//a[@title='Close']")).click();

//Use action class for drag and drop
        Actions action=new Actions(driverc);
        action.clickAndHold(driverc.findElement(By.xpath("//a[@title='Close']")))
                .moveToElement(driverc.findElement(By.xpath("//a[@title='Close']")))
                .release()
                .build()
                .perform();

        /*String mainWindowHandle = driverc.getWindowHandle();
        System.out.println("MainWindow handle is" + mainWindowHandle);
        for (String childWindowHandle : driverc.getWindowHandles()) {
            System.out.println("Inside for loop handle is");
            //If window handle is not main window handle then close it
            System.out.println("childWindowHandle is" + childWindowHandle);
            if(!childWindowHandle.equals(mainWindowHandle)){
                driverc.switchTo().window(childWindowHandle);
                // Close child windows
                driverc.close();

            }
        }
*/
//switch back to main window
        //driver.switchTo().window(mainWindowHandle);
        //driverc.findElement(By.xpath("//a[@title='Close']")).click();
       // driverc.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Users\\slava820\\Desktop\\test123.txt");
        //System.out.println(driverc.getTitle());
        //Alert alert=driverc.switchTo().alert();
        //alert.dismiss();
        //driverc.findElement(By.xpath("//input[@name='fileupload']")).click();
        /*WebDriverWait wait=new WebDriverWait(driverc,10);
       WebElement linktoapprear;
        linktoapprear= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]")));
*/
    }

}
