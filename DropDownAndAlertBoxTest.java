package intellipaat.Project1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAndAlertBoxTest {
	
WebDriver driver;
    
	@BeforeClass
    public void setUp() {
		
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }
	
	@Test
	public void testDropDownMenus() throws InterruptedException {
		
		 // Open the drop-down menu demo page
        driver.get("https://demoqa.com/select-menu");

        // Wait for page to load
        Thread.sleep(2000);

        // Locate the old-style drop-down menu (Select class supports this)
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));

        // Create Select object
        Select select = new Select(dropdown);

        // Select options
        select.selectByVisibleText("Purple");
        Thread.sleep(1000);

        select.selectByIndex(5); // Selects "Black"
        Thread.sleep(1000);

        select.selectByValue("6"); // Selects "White"
        Thread.sleep(1000);

        System.out.println("Drop-down selections completed.");
	}
	
	@Test
	public void testAlertBoxes() throws InterruptedException {
		
		// Open Alerts demo page
        driver.get("https://demoqa.com/alerts");
        

        // ========= Alert Box (OK) =========
        
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1000);
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert1.getText());
        alert1.accept(); // Click OK
        
        

        // ========= Confirm Box (OK/Cancel) =========
        
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1000);
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Confirm Text: " + alert2.getText());
        alert2.dismiss(); // Click Cancel
        
        

        // ========= Prompt Box (Enter text + OK) =========
        
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(1000);
        Alert alert3 = driver.switchTo().alert();
        System.out.println("Prompt Text: " + alert3.getText());
        alert3.sendKeys("Selenium Test");
        alert3.accept(); // Click OK

        System.out.println("All alerts handled successfully!");
	}
	
	
	@AfterClass
	public void tearDown() {
		
	    driver.quit();
	}

}
