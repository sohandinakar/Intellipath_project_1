package intellipaat.Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WidgetsTest {
	
	 WebDriver driver;
	    
		@BeforeClass
	    public void setUp() {
			
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	    }
		
		
		@Test
	    public void testDatePicker() throws InterruptedException {
			
			// Open jQuery DatePicker demo
			driver.get("https://jqueryui.com/datepicker/");
			
			// Switch to iframe (jQuery UI uses an iframe for the demo)
	        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

	        // Click the input field to open the date picker
	        WebElement dateField = driver.findElement(By.id("datepicker"));
	        dateField.click();
	        
	        //Wait
	        Thread.sleep(3000);

	        // Choose a date (e.g., 10th of the current month)
	        driver.findElement(By.xpath("//a[text()='10']")).click();

	        // Wait and print selected date
	        Thread.sleep(1000);
	        System.out.println("Selected date: " + dateField.getAttribute("value"));
		}
		
		@Test
		public void testTab() throws InterruptedException {
			
			
			// Open jQuery Tabs demo
	        driver.get("https://jqueryui.com/tabs/");
	        
	        // Switch to the iframe that contains the tabs
	        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	        
	        //Wait
	        Thread.sleep(3000);

	        // Click on the second tab
	        WebElement tab2 = driver.findElement(By.xpath("//a[@href='#tabs-2']"));
	        tab2.click();
	        Thread.sleep(1000); // wait for tab content to load

	        // Get tab content and print it
	        WebElement tabContent = driver.findElement(By.id("tabs-2"));
	        System.out.println("Tab 2 content: " + tabContent.getText());
		}
		
		@Test
		public void testSlider() throws InterruptedException {
			
			
			// Open jQuery slider demo
	        driver.get("https://jqueryui.com/slider/");
	        
	        // Switch to iframe that contains the slider
	        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

	        // Find the slider handle
	        WebElement sliderHandle = driver.findElement(By.xpath("//div[@id='slider']/span"));

	        //Wait
	        Thread.sleep(3000);
	        
	        // Move the slider using Actions
	        Actions actions = new Actions(driver);
	        actions.dragAndDropBy(sliderHandle, 100, 0).perform(); // move right by 100 pixels

	        Thread.sleep(1000);
	        System.out.println("Slider moved successfully.");
		}
		
		
		@AfterClass
		public void tearDown() {
			
		    driver.quit();
		}
}

