package testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.JavaUtility;

public class TC_01_Login {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		//read data from property file
		JavaUtility jv= new JavaUtility();
		String URL = jv.readDataFromPropertyFile("url") ;
		String USERNAME = jv.readDataFromPropertyFile("username");
		String PASSWORD = jv.readDataFromPropertyFile("password");
		
		//launch the browser and navigate to application
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//Login to the application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login Sucessful");
		
		Thread.sleep(30);
		
		//Logout the application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.quit();

	}

}
