package com.stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCart {
	
	WebDriver driver;
	
	@Given("user should be on amazon home page")
	public void user_should_be_on_amazon_home_page() {
        //System.out.println("step1 : user should be on amazon home page");
	   
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium wedrivers\\ChromeDriver109\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https:\\www.amazon.com");
		driver.manage().window().maximize();
		Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();
		while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            // Switching to Child window
            driver.switchTo().window(ChildWindow);	                                                                                                           
            System.out.print(" .... "+driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[1]/div/div/div[2]")).getText());                            
			driver.findElement(By.className("a-button-input")).click();
            // Closing the Child Window.
           // driver.close();				
        }
		
	}
	

	@When("user click on shopping cart")
	public void user_click_on_shopping_cart() {
		//System.out.println("step2 : user click on shopping cart ");
		driver.findElement(By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]")).click();
	}

	//@And("redirected to shopping cart page")
	//public void redirected_to_shopping_cart_page() {
	//	String s = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div[2]/div[1]/h2")).getText();
	//}

	@Then("cart should be empty")
	public void cart_should_be_empty() {
		
		//System.out.println("step3 : cart_should_be_empty ");
		String s = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div[2]/div[1]/h2")).getText();
		System.out.println(s);
		driver.close();
	}
	
	
}
