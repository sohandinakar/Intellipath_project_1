package intellipaat.Project1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsTest {
	
	WebDriver driver;
    
	@BeforeClass
    public void setUp() {
		
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }
	
	@Test
	public void testDraggable() throws InterruptedException {
		
		 // Open jQuery draggable demo
        driver.get("https://jqueryui.com/draggable/");
        
        // Switch to iframe containing the draggable box
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Locate the draggable element
        WebElement draggable = driver.findElement(By.id("draggable"));
        
        //Wait
        Thread.sleep(3000);

        // Perform drag action
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, 100, 50).perform(); // move 100px right, 50px down

        Thread.sleep(1000);
        System.out.println("Element dragged successfully.");
		 
	}
	
	@Test
	public void testResizable() throws InterruptedException {
		
		// Open jQuery resizable demo
        driver.get("https://jqueryui.com/resizable/");
        
        // Switch to the iframe containing the resizable box
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Locate the resize handle (bottom-right corner)
        WebElement resizeHandle = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
        
        //Wait
        Thread.sleep(3000);
        
        // Perform resize using Actions class
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle).moveByOffset(100, 50).release().perform(); // Resize by 100px right, 50px down

        Thread.sleep(1000);
        System.out.println("Resizable box resized successfully.");
	}
	
	@Test
	public void testSelectable() throws InterruptedException {
		
		// Open jQuery Selectable demo
        driver.get("https://jqueryui.com/selectable/");

        // Switch to the iframe containing the list
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Get list of selectable items
        List<WebElement> items = driver.findElements(By.xpath("//ol[@id='selectable']/li"));

        //Wait
        Thread.sleep(3000);
        
        // Select multiple items using Actions class (e.g., items 1 to 3)
        Actions actions = new Actions(driver);
        actions.clickAndHold(items.get(0))
               .moveToElement(items.get(2))
               .release()
               .perform();

        Thread.sleep(1000);
        System.out.println("Items selected successfully.");
	}
	
	
	@AfterClass
	public void tearDown() {
		
	    driver.quit();
	}

}
