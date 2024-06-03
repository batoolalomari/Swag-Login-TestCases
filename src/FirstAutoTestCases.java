import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstAutoTestCases  {
	
	//global declaration
	WebDriver driver= new ChromeDriver();

	@BeforeTest
	public void setUp() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test (priority = 1)
	public void logIn() throws InterruptedException {
		//Login
		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
		Thread.sleep(1500);

	}
	
	@Test (priority = 2)
	public void  firstTestCases() throws InterruptedException {
		//Add 6 items
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        Thread.sleep(1500);
	}

	@Test(priority = 3)
	public void removeFirstItem() throws InterruptedException{
		//Select item to open item details page and remove it  
		//find web element by test attribute
		driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@data-test='remove']")).click();
		Thread.sleep(1500);		
		driver.findElement(By.xpath("//button[@data-test='back-to-products']")).click();
		Thread.sleep(1500);
	}
	
	@Test(priority = 4)
	public void checkCart() throws InterruptedException{
		//open cart page then and back to home
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}
	
	@Test(priority = 5)
	public void addItemandLogout() throws InterruptedException {
		//back to home page then add first item then Log out
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).sendKeys(Keys.ENTER);
	}
	
}
