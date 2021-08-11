package com.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.JVMReport;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", glue = "com.stepdefinition", dryRun = false, monochrome = true, plugin = {
		"pretty", "json:src\\test\\resources\\Report\\adactin.json" }, snippets = SnippetType.CAMELCASE, strict = true)
public class TestRunner {
	@AfterClass
	public static void afterClass() {
		JVMReport.generateJvmReport(System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\adactin.json");

	}

}
