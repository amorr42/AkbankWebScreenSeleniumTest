package stepDefinitions;

import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.HomePage;
import testBase.TestBase;

public class LoansStepDefinition extends TestBase {
	
	HomePage homePage;
	
	
	@Given("^Open Akbank Home Page$")
	public void open_Akbank_Home_Page() throws Throwable {
		homePage = new HomePage();
		Thread.sleep(1000);
	}

	@And("^Click Loans Calculation$")
	public void click_Loans_Calculation() throws Throwable {
	    homePage.click_Loans();
	    Thread.sleep(1000);
	}

	@And("^Enter Amount \"([^\"]*)\" in price field$")
	public void enter_Amount_in_price_field(String amount) throws Throwable {
	    homePage.send_Price(amount);
	    Thread.sleep(1000);
	}

	@And("^Choose Uninsured$")
	public void choose_Uninsured() throws Throwable {
	   homePage.click_Uninsured();
	   Thread.sleep(1000);
	}

	@And("^Set Maturity as twenty months$")
	public void set_Maturity_as_twenty_months() throws Throwable {
	    homePage.set_Maturity();
	    Thread.sleep(1000);
	}

	@And("^Click Calculation Details$")
	public void click_Calculation_Details() throws Throwable {
	    homePage.click_SumDetails();
	    Thread.sleep(1000);
	}
	
	
	@And("^Check Masraf ve Maliyet Oranlar screen$")
	public void check_Masraf_ve_Maliyet_Oranlar_screen() throws Throwable {
	    homePage.checkTitle();
	    Thread.sleep(1000);
	}
	
	@And("^Click Payment Scheme$")
	public void click_Payment_Scheme() throws Throwable {
	    homePage.choose_PaymentScheme();
	    Thread.sleep(1000);
	}
	
	@And("^Check Payment Scheme screen$")
	public void check_Payment_Scheme_screen() throws Throwable {
	   homePage.verify_Title();
	   Thread.sleep(1000);
	}

	@And("^Scroll down Payment Scheme page$")
	public void scroll_down_Payment_Scheme_page() throws Throwable {
	    homePage.scroll_PaymentScheme();
	    Thread.sleep(1000);
	}
	
	
	
}
