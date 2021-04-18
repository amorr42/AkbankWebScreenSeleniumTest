package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testUtil.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties properties;
	public static String currentDirectory = System.getProperty("user.dir");

	public TestBase() {

		properties = new Properties();
		try {
			properties.load(new FileInputStream(currentDirectory + "//src//test//resources//config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = properties.getProperty("browser");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		if (browserName.equals("chrome")) {
			// driver = new ChromeDriver();
			ChromeOptions optns = new ChromeOptions();
			optns.addArguments("disable-infobars");
			driver = new ChromeDriver(optns);
			System.out.println("Browser is set to Chrome");
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Browser is set to Firefox");
		} else {
			driver = new InternetExplorerDriver();
			System.out.println("Browser is set to IE");
		}
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("url"));
	}
	
	 public void waitElemetVisible(int timeout,WebDriver driver,By element) 
	 {
	    new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
	 }
		
	public void waitElemetClick(int timeout,WebDriver driver,By element) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public static void closeBrowser() {
		driver.quit();
	}

}
