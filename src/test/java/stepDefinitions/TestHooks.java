package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import testBase.TestBase;


public class TestHooks extends TestBase {

	public TestHooks(){
		super();
	}
	
	@Before
	public void setUp() {
		new TestHooks();
		TestBase.initialization();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		
		
	}
}
