package SeleniumSessions.PackageSeleniumSessions;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {
	//public static void main (String[] args) {
	public static void SelectBootStrapDropdown(String value) {
	System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown')]")).click();
       List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown')]//li//a//label"));
       for(int i=0;i<list.size();i++){
    	 System.out.println(list.get(i).getText());
    	if (list.get(i).getText().contains(value)){
    		if(list.get(i).isSelected()) {
	    		//do nothing
	    	}
    	else {
    		list.get(i).click();
	    	break;
    	}
    		
       }
    	}
	}

public static void main (String[] args) {
	   SelectBootStrapDropdown("HTML");
	   
}
}
