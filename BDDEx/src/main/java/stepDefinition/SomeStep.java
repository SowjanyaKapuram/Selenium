package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SomeStep {

	WebDriver driver;
	
	@Given("^user is logging in$")
	public void user_is_logging_in() throws Throwable {
	     
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VJIT\\Desktop\\Module-3_Workspace\\BDDEx\\src\\main\\java\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:8880/SampleDynamicWebProject/index.jsp");
	    
	}

	@When("^title of login page is something$")
	public void title_of_login_page_is_something() throws Throwable {
	    
	    String title= driver.getTitle();
	    assertEquals("something", title);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
	    driver.findElement(By.name("uname")).sendKeys("sowjanya");
	    driver.findElement(By.name("password")).sendKeys("sowjanya");
	}

	@Then("^click on the login button$")
	public void click_on_the_login_button() throws Throwable {
	    
		WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginbtn);
		
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	   
		String title = driver.getTitle();
		assertEquals("nothing", title);
	}


	
	
}
