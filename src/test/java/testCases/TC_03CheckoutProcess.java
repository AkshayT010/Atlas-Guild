package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.JavaUtility;

public class TC_03CheckoutProcess {

	public static void main(String[] args) throws IOException {
		
		//read data from property file
		JavaUtility jv= new JavaUtility();
		String URL = jv.readDataFromPropertyFile("url") ;
		String USERNAME = jv.readDataFromPropertyFile("username");
		String PASSWORD = jv.readDataFromPropertyFile("password");
				
		//Read data from excel file
		String ProductToBeAdded = jv.readDataFromExcelFile("TestCases", 4, 2);
		System.out.println("Product name is"+ProductToBeAdded);
		
		//Launching Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		//Login to application
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
				
		//Add a product to cart
		driver.findElement(By.xpath("//div[.='"+ProductToBeAdded+"']")).click();
		driver.findElement(By.id("add-to-cart")).click();
				
		//Go to cart and complete the checkout process
		driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Akshay");
		driver.findElement(By.id("last-name")).sendKeys("Tarade");
		driver.findElement(By.id("postal-code")).sendKeys("411061");
				
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		System.out.println("Order is placed");
		System.out.println("TestScipt is passed");
				
		//LogOut from application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.quit();
				

	}

}
