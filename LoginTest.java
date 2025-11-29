package intellipaat.Project1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
    WebDriver driver;
    
	@BeforeClass
    public void setUp() {
		
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/"); 
    }

    @Test
    public void testLogin()  {
    	
    	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    	driver.findElement(By.xpath("//input[@name='login-button']")).click();
    	new WebDriverWait(driver, Duration.ofSeconds(3));

    	String ExpectedURL="https://www.saucedemo.com/inventory.html";
		String ActualURL=driver.getCurrentUrl();
		if(ExpectedURL.equals(ActualURL))
		{
			System.out.println("Test Passed -Login Success");
		}
		else
		{
			System.out.println("Test Failed -Login Failed");
		}
		new WebDriverWait(driver, Duration.ofSeconds(3));
    }

   

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
		
		

}


