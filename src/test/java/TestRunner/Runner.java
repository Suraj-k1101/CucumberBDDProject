package TestRunner;

import io.cucumber.testng.CucumberOptions;

//we will import some packages

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)
@CucumberOptions(
//		features = "src/test/resources/Features/Customers.feature",  //path of feature file
//		features = "src/test/resources/Features",
//		features = {"src/test/resources/Features/Customers.feature","src/test/resources/Features/LoginFeatureDataDriven.feature"},
		features = {"src/test/resources/Features/LoginFeature.feature","src/test/resources/Features/Customers.feature"},
		
		
		glue = {"stepDefinitions"},   //path of step definition file which is present in stepDefinitions package
		dryRun = false , //it will check whether we have done implementation of all steps of feature in the step definition file or not if we set dryRun = true
		monochrome = true,  //this is used for output readability
		tags= "@Sanity",//because of this scenarios under @Sanity tags will be executed only
//		plugin = {"pretty","html:target/cucumber-reports/report_html.html"} //this is used for report generating
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}//this plugin is for generating for extent report
	
		)

//plugin = {"pretty","json:target/cucumber-reports/reports_json.json"} 
//plugin = {"pretty","junit:target/cucumber-reports/reports_xml.xml"}

public class Runner extends AbstractTestNGCucumberTests {//we are create this Runner class for executing our test cases

//this class will be empty	
	

}
