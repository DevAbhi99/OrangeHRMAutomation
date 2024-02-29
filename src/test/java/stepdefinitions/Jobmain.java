package stepdefinitions;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import controller.Jobcontroller;
import controller.Logincontroller;
import controller.Logoutcontroller;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Jobmain {

	public static WebDriver driver=null;
	
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

@Given("the user is on the login page of the website")
public void the_user_is_on_the_login_page_of_the_website() {
    
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\BrowserDriver\\chromedriver.exe");
	
	driver=new ChromeDriver();
	
	driver.get(url);
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
}

@When("the user provides valid username (.*) and valid password (.*)$")
public void the_user_provides_valid_username_admin_and_valid_password_admin123(String username,String password)throws Exception {
    
	Logincontroller.uname(driver).sendKeys(username);
	
	Thread.sleep(3000);
	
	Logincontroller.pword(driver).sendKeys(password);
	
	Thread.sleep(3000);
	
}

@When("the user clicks on the login button")
public void the_user_clicks_on_the_login_button() {
	
	Logincontroller.login(driver).click();
	
	
    
}

@Then("the user gets acccess to the landing page of the website")
public void the_user_gets_acccess_to_the_landing_page_of_the_website() {
   
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	System.out.println("Landing page accesseed!");
	
}

@Given("the user is on the landing page of the website")
public void the_user_is_on_the_landing_page_of_the_website() {
  
	System.out.println("\n\nUser is on the landing page");
}

@When("the user clicks on the Admin tab")
public void the_user_clicks_on_the_admin_tab()throws Exception {

	Jobcontroller.admin(driver).click();
	
	Thread.sleep(3000);

	
}

@When("the user clicks on the job drop down and the clicks on Job titles tab")
public void the_user_clicks_on_the_job_drop_down_and_the_clicks_on_job_titles_tab()throws Exception {

	Jobcontroller.jobTab(driver).click();
	
	Thread.sleep(3000);
	
	Jobcontroller.jobTitles(driver).click();

	Thread.sleep(3000);
}

@Then("list of jobs are displayed")
public void list_of_jobs_are_displayed()throws Exception {
    
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("window.scrollBy(0, 900)");
	
	Thread.sleep(3000);
	
	File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(file, new File("C:\\Users\\TIRTHANKAR KHAUND\\Pictures\\Saved Pictures\\OrangeHrm.png"));

	Thread.sleep(3000);
	
	String s=Jobcontroller.jobList(driver).getText();
	
	String[] res=s.split("\n");

	System.out.println("\n\nThe job lists are:\n");
	
	int count=0;
	
	for(int i=0;i<res.length;i++) {
	
		System.out.print(res[i]);
		
		if(res[i].contains("QA")) {
			count++;
		}
	}
	
	
	if(count!=0) {
		System.out.println("\nQA found!");
	}else {
		System.out.println("\nQA not found!");
	}
	
	Thread.sleep(3000);
	
}

@When("the user clicks on the profile tab on the right top corner")
public void the_user_clicks_on_the_profile_tab_on_the_right_top_corner()throws Exception {

	Logoutcontroller.profile(driver).click();
	
	Thread.sleep(5000);
	
	
}

@When("the user clicks on the logout button")
public void the_user_clicks_on_the_logout_button()throws Exception {
    
	Logoutcontroller.logout(driver).click();
	
	Thread.sleep(3000);
}

@Then("the user gets logged out and redirected to the login page")
public void the_user_gets_logged_out_and_redirected_to_the_login_page() {

	System.out.println("\nUser is finally logged out!");

	driver.close();
}

	
}
