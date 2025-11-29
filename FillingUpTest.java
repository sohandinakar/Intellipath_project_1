package intellipaat.Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FillingUpTest {
	
WebDriver driver;
    
	@BeforeClass
    public void setUp() {
		
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }
	
	@Test
	public void testRegistrationandSubmission() throws InterruptedException {
		
		
		// Open the registration form
        driver.get("https://demo.automationtesting.in/Register.html");

        // Fill the registration form
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Doe");
        
        //Wait
        Thread.sleep(2000);
        
        
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("john.doe@example.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9876543210");

        //Wait
        Thread.sleep(2000);
        
        // Select gender
        driver.findElement(By.xpath("//input[@value='Male']")).click();


        // Set password and confirm password
        driver.findElement(By.id("firstpassword")).sendKeys("Password123");
        driver.findElement(By.id("secondpassword")).sendKeys("Password123");

        // Click the submit button
        driver.findElement(By.id("submitbtn")).click();

        Thread.sleep(2000);
        System.out.println("Registration form submitted successfully.");
	}
	
	
	@AfterClass
	public void tearDown() {
		
	    driver.quit();
	}


}
