package com.stepdefinition;

import org.base.LibGlobal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends LibGlobal {
	public static LibGlobal global;

	@Before
	public void beforeScenario() {
		global = new LibGlobal();
		driver = global.getdriver("chrome");
		global.maximize();
		global.loadUrl("https://adactinhotelapp.com/");
	}

	@After
	public void screenshot(Scenario sc) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		sc.embed(screenshotAs, sc.getName() + "png");
		global.closeAllWindlows();

	}

}
