import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingFlight {

	public static void main(String[] args) {

			System.setProperty("webdriver.gecko.driver","D:\\Automation_Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();

			driver.get("https://www.expedia.com");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			String title = driver.getTitle(); System.out.println(title);

			 if (title.equals("Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations")) 
			 { System.out.println("Correct Title"); } 
			 else {
				System.out.println("Incorrect Title"); }
		
		   WebElement date = driver.findElement(By.id("flight-departing-hp-flight"));
		   String dateVal = "11/30/2019";
		   WebElement date1 = driver.findElement(By.id("flight-returning-hp-flight"));
		   String dateVal1 = "12/10/2019";

		   driver.findElement(By.id("tab-flight-tab-hp")).click();
		   driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("LGB");

		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		   List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

		   System.out.println("Total no. of suggestions in search box -->" + list.size());
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//clickOn(driver, driver.findElement(By.xpath("//*[contains(text(),'Long Beach, CA, United States')]")), 10);
		   for (int i = 0; i < list.size(); i++)  { 
			  System.out.println(list.get(i).getText()); 
			  if (list.get(i).getText().contains("Long Beach")) {
			  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
			  list.get(i).click(); 
			  list.get(i).click();
			  break; 
			  } 
		  }
		 
		   driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("San Francisco");
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		   	List<WebElement> list2 = driver.findElements(By.xpath("//ul[@class='results']//li"));
			System.out.println("Total no. of suggestions in search box -->" + list2.size());
			System.out.println(list2);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			  for (int i = 0; i < list2.size(); i++)  { 
				  System.out.println(list2.get(i).getText()); 
			  if (list2.get(i).getText().contains("San Francisco"))
			  {
				  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
				  list2.get(i).click();
				  list2.get(i).click();
				  break; 
				  } 
			  }
			  
			  selectDateByJS(driver, date, dateVal);  
			  selectDateByJS(driver, date1, dateVal1);
			  
			  
			  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
			  driver.findElement(By.xpath("//*[@type='submit' and @class='btn-primary btn-action gcw-submit']")).click();
			  //driver.findElement(By.xpath("//*[@type='submit']")).click();
			  //driver.findElement(By.xpath("//*[@id='search-button-hp-package']")).click();
		  
		//driver.quit();
 }
		public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		}
 }
	/*
	 * public static void clickOn(WebDriver driver, WebElement locator, int timeout)
	 * { new WebDriverWait(driver,
	 * timeout).ignoring(StaleElementReferenceException.class).until(
	 * ExpectedConditions.elementToBeClickable(locator)); locator.click();
	 * //WebDriverWait is a class in Selenium;ExpectedCondition is a class in
	 * Selenium }
	 */
 
//1. Firefox Driver >> geckodriver
//Web Driver is the interface; FirefoxDriver is Selenium class
//2. Chrome Driver 
//System.setProperty("webdriver.chrome.driver", "D:\\Automation_Selenium\\chromedriver_win32\\chromedriver.exe");
//WebDriver driver = new ChromeDriver();
//System.out.println(driver.getCurrentUrl());
//System.out.println(driver.getPageSource());