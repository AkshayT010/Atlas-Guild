package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.JavaUtility;

public class TC_02AddProductToCart {

	public static void main(String[] args) throws IOException {
		
		//read data from property file
		JavaUtility jv= new JavaUtility();
		String URL = jv.readDataFromPropertyFile("url") ;
		String USERNAME = jv.readDataFromPropertyFile("username");
		String PASSWORD = jv.readDataFromPropertyFile("password");
				
		//Read data from excel file
		String ProductToBeAdded = jv.readDataFromExcelFile("TestCases", 1, 2);
		
		//Launching Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login to application
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		// Add a product to cart
		
	//	String productTobeAdded = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		driver.findElement(By.xpath("//div[.='"+ProductToBeAdded+"']")).click();
		driver.findElement(By.id("add-to-cart")).click();
		
		//Verify right product is added or not
		
		driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
		String productAdded = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		
		if(ProductToBeAdded.equals(productAdded))
		{
			System.out.println("Right product is added");
			System.out.println("TestScript is passed");
		}
		else
		{
			System.out.println("Wrong product is added");
			System.out.println("TestScript is failed");
		}
		
		//LogOut from application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.quit();

	}

}
