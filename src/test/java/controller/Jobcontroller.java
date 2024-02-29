package controller;
import org.openqa.selenium.*;
import pages.Jobpage;

public class Jobcontroller {

	public static WebElement element=null;
	
	public static WebElement admin(WebDriver driver) {
		
		element=driver.findElement(Jobpage.adminTab);
		
		return element;
	}
	
	public static WebElement jobTab(WebDriver driver) {
		
		element=driver.findElement(Jobpage.job);
		
		return element;
	}
	
	public static WebElement jobTitles(WebDriver driver) {
		
		element=driver.findElement(Jobpage.jobTitle);
		
		return element;
	}
	
	public static WebElement jobList(WebDriver driver) {
		
		element=driver.findElement(Jobpage.jobList);
		
		return element;
	}
	
	
}
