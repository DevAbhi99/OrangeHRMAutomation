package controller;
import org.openqa.selenium.*;
import pages.Logoutpage;

public class Logoutcontroller {

	public static WebElement element=null;
	
	public static WebElement profile(WebDriver driver) {
		
		element=driver.findElement(Logoutpage.profileTab);
		
		return element;
	}

	public static WebElement logout(WebDriver driver) {
		
		element=driver.findElement(Logoutpage.logoutBtn);
		
		return element;
	}
	
	
	
}
