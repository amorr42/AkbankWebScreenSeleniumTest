package pages;


import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import org.apache.velocity.anakia.AnakiaElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Converter;

import testBase.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public static WebDriverWait wait;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Kredi Hesaplama']")
	@CacheLookup
	WebElement btn_Loans;
	
	@FindBy(how = How.ID, using = "t-credit-price")
	@CacheLookup
	WebElement txt_Price;
	
	@FindBy(how = How.XPATH, using = "//label[@for='insuredType2']")
	@CacheLookup
	WebElement btn_Uninsured;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ui-slider-range ui-widget-header ui-corner-all ui-slider-range-min')]")
	@CacheLookup
	WebElement slider_Maturity;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-function,'calculate')]")
	@CacheLookup
	WebElement btn_SumDetails;
	
	@FindBy(how = How.CSS, using = "#accordion1")
	@CacheLookup
	WebElement txt_ChargeandCost; 
	
	
	@FindBy(how = How.CSS, using = "#accordion2")
	@CacheLookup
	WebElement btn_PaymentScheme; 
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'jspPane')]//th[contains(text(),'Dönem')]")
	@CacheLookup
	WebElement verify_PaymentScheme; 
	
	
	@FindBy(how = How.CLASS_NAME, using = "jspVerticalBar")
	@CacheLookup
	WebElement slider_PaymentScheme; 
	
	
	
	
	
	public void click_Loans() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btn_Loans);
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btn_Loans));
		wait.until(ExpectedConditions.elementToBeClickable(btn_Loans));
		btn_Loans.click();
		
	}

	
	public void send_Price(String price) {
			
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(txt_Price));
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txt_Price);
		
		wait.until(ExpectedConditions.elementToBeClickable(txt_Price));
		
		txt_Price.clear();
		txt_Price.sendKeys(price);
		
			    
	}
	
	public void click_Uninsured() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btn_Uninsured));
		
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_Uninsured);
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_Uninsured));
		
		txt_Price.click();
		
			    
	}
	
	public void set_Maturity() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(slider_Maturity));
		
		int x=10;
		   
		int width = slider_Maturity.getSize().getWidth();
		Actions act= new Actions(driver);
		act.moveToElement(slider_Maturity, ((width*x)/200), 0).click();
		act.build().perform();
		    
	}
	
			    
	public void click_SumDetails() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btn_Uninsured));
	
		btn_SumDetails.click();
				    
	}
	
	
	public void checkTitle() {
		
		String text = txt_ChargeandCost.getAttribute("innerText");
		System.out.println(text);
		String title = "Masraf ve Maliyet Oranlar";
		
		if(text.contains(title)) {
			System.out.println("Masraf ve Maliyet Oranlar");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false,"Actual title :"+txt_ChargeandCost.getAttribute("innerText")+" does not contains"+ title);
		
	}

	
	

	public void choose_PaymentScheme() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btn_PaymentScheme));
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_PaymentScheme);
				
		/*JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,600);", slider_PaymentScheme);*/
		
	}
	
	
	public void verify_Title() {
		
		String text = verify_PaymentScheme.getAttribute("innerText");
		System.out.println(text);
		String title = "Dönem";
		
		if(text.contains(title)) {
			System.out.println("Dönem");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false,"Actual title :"+verify_PaymentScheme.getAttribute("innerText")+" does not contains"+ title);
		
	}


	public void scroll_PaymentScheme() {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(slider_PaymentScheme));
		
		for(int i=0; i<=17; i++){
			Actions action = new Actions(driver);
			action.sendKeys(slider_PaymentScheme, Keys.ARROW_DOWN).build().perform();
		}
		
		
		

		
	}


	
	
	
	
	
	
	
	
}
