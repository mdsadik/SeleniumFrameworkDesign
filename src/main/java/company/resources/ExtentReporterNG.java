package company.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";// to get the project path and save the report
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//creating object:reporter for ExtentSparkReporter
		reporter.config().setReportName("Automation Result");//
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent= new ExtentReports();//create an object of ExtentReports
		extent.attachReporter(reporter);//report will attach to main class
		extent.setSystemInfo("Tester", "Automation");
		return extent;
		
	}
}
