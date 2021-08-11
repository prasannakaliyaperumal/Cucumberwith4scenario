package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	
	public static void generateJvmReport(String jsonFile) {
		String path = System.getProperty("user.dir");
		File reportDirectory = new File(path+"\\src\\test\\resources\\Report");
		Configuration configuration = new Configuration(reportDirectory, "Adactin Automation");
		configuration.addClassifications("OS", "Windows 10");
		configuration.addClassifications("Browser", "chrome");
		configuration.addClassifications("version", "92");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
		
		
	}

}
