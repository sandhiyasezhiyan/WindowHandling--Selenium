package LearnActionclassAssignment;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnLeafappswindowhandling {
public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	
	WebElement clickcontact= driver.findElement(By.linkText("Contacts"));
	Actions builder = new Actions(driver);
	builder.moveToElement(clickcontact).click().perform();
	
	WebElement mergecontact = driver.findElement(By.linkText("Merge Contacts"));
	builder.moveToElement(mergecontact).click().perform();
	
	WebElement fromcontacttable = driver.findElement(By.xpath("//img[@alt='Lookup'][1]"));
	fromcontacttable.click();
	
	
	//list of windows
	Set<String> window = driver.getWindowHandles();
	List<String>listwindows = new ArrayList<String>(window);
	driver.switchTo().window(listwindows.get(1));
	driver.manage().window().maximize();
	
	//inside the window
	driver.findElement(By.linkText("DemoCustomer")).click();
	
	//move to parent window
	driver.switchTo().window(listwindows.get(0));
	
	
	WebElement tocontacttable = driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]"));
	tocontacttable.click();
	
	
	//list of windows
		Set<String> window1 = driver.getWindowHandles();
		List<String>listwindows1 = new ArrayList<String>(window1);
		driver.switchTo().window(listwindows1.get(1));
		driver.manage().window().maximize();
		
		//inside the window
		driver.findElement(By.linkText("DemoLBCust")).click();
		
		//move to parent window
		driver.switchTo().window(listwindows1.get(0));
		
		
		driver.findElement(By.linkText("Merge")).click();
		
		Alert learnalert1 = driver.switchTo().alert();
		learnalert1.accept();
		
		String title = driver.getTitle();
		System.out.println("the title of the page:" +title);
		if(title.contains("view")) {
			System.out.println("merge successfull");
		}
		
		
		
	
	
	
	
	
}
}
