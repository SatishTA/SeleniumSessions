package SeleniumSessions.PackageSeleniumSessions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterConcept {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Office BackUP\\Documents\\Sele_WorkSpace\\test\\target\\chromedriver.exe");
        WebDriver driverc = new ChromeDriver();//launch Chrome
        driverc.manage().window().maximize();//Maximize the window
        driverc.manage().deleteAllCookies();//Delete the cookies

        driverc.get("https://www.freecrm.com");//Launch the application
        //Dynamic wait
        driverc.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driverc.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        System.out.println("Before Login Title is "+driverc.getTitle());
        Thread.sleep(3000);
        driverc.findElement(By.name("username")).sendKeys("naveenk");
        driverc.findElement(By.name("password")).sendKeys("test@123");
        WebElement loginbtn=  driverc.findElement(By.xpath("//input[@type='submit']"));//login button xpath

        flash(loginbtn,driverc);//"highlight the object"

        drawBorder(loginbtn,driverc);//draw a border to highlighted

        //Take screenshot
        //take screenshot and save as a file format
        File src = ((TakesScreenshot)driverc).getScreenshotAs(OutputType.FILE);
        //copy the screenshot and save to your location
        FileUtils.copyFile(src, new File("D:\\Office BackUP\\Documents\\Selenium_Session\\Element.png"));

        //Generate alert

        generateAlert(driverc,"This is alert for login button");
    }
    public static void flash(WebElement element, WebDriver driverc){
                    JavascriptExecutor js= ((JavascriptExecutor) driverc);
                    String bgcolor = element.getCssValue("backgroundColor");
                    for (int i=0; i<10; i++) {
                        changeColor("rgb(0,400,0)", element, driverc);
                        changeColor(bgcolor, element, driverc);
                    }

    }
    public static void changeColor(String color, WebElement element, WebDriver driverc){

        JavascriptExecutor js =((JavascriptExecutor) driverc);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
        try {
            Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
    }
    //Mehtod to draw the border to object
    public static void drawBorder(WebElement element, WebDriver driverc)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driverc);
        js.executeScript("arguments[0].style.border='3px solid red'" , element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }

    //Generate alert using java script
    public static void generateAlert(WebDriver driverc, String message){
        JavascriptExecutor js = ((JavascriptExecutor) driverc);
        js.executeScript("Alert('"+message+"')");
    }

}
