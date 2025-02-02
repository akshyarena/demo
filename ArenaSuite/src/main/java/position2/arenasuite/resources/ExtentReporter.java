package position2.arenasuite.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentreport;
	

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(path);
		extentsparkreporter.config().setReportName("Arena Automation results");
		extentsparkreporter.config().setDocumentTitle("Arena Automatuion results");
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(extentsparkreporter);
		extentreport.setSystemInfo("Tester", "Akshay Viswanath");
		return extentreport;
	}

}
