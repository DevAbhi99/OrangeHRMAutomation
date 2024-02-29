package controller;
import org.openqa.selenium.*;
import pages.Loginpage;

public class Logincontroller {

	public static WebElement element=null;
	
	public static WebElement uname(WebDriver driver) {
		
		element=driver.findElement(Loginpage.username);
		
		return element;
	}
	
	public static WebElement pword(WebDriver driver) {
		
		element=driver.findElement(Loginpage.password);
		
		return element;
	}
	
	public static WebElement login(WebDriver driver) {
		
		element=driver.findElement(Loginpage.loginBtn);
		
		return element;
	}
	
}
