package intellipaat.Project1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAndWindowsTest {
	
WebDriver driver;
    
	@BeforeClass
    public void setUp() {
		
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }
	
	@Test
	public void testFrames() throws InterruptedException {
		
		// Open the DemoQA Frames page
        driver.get("https://demoqa.com/frames");

        // Switch to first frame (frame1)
        driver.switchTo().frame("frame1");
        WebElement heading1 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text in Frame1: " + heading1.getText());
        
        Thread.sleep(2000);

        // Switch back to main page
        driver.switchTo().defaultContent();

        // Switch to second frame (frame2)
        driver.switchTo().frame("frame2");
        WebElement heading2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text in Frame2: " + heading2.getText());

        
        // Back to main page
        driver.switchTo().defaultContent();
		
    }
	
	@Test
	public void testWindows() throws InterruptedException {
		
		// Open the windows demo page
        driver.get("https://demo.automationtesting.in/Windows.html");

        // Click on the "click" button to open new window
        driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']")).click();

        // Store the original window handle
        String originalWindow = driver.getWindowHandle();

        // Wait and switch to new window
        Thread.sleep(2000);
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Print the title of new window
        System.out.println("New window title: " + driver.getTitle());

        // Close the new window
        driver.close();

        // Switch back to original window
        driver.switchTo().window(originalWindow);
        System.out.println("Switched back to original window: " + driver.getTitle());
        
        Thread.sleep(2000);
	}
	
	@AfterClass
	public void tearDown() {
		
	    driver.quit();
	}


}
