package StepDefinitionFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BaseTest.BaseClass;
import PageObjectModel.CarInsurance1;
import PageObjectModel.HealthInsurance1;
import PageObjectModel.Travelinsurance1;
import Utils.ExcelforInsurance;
import Utils.ScreenShots;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PolicyBazaar {
	public WebDriver driver =BaseClass.getDriver();
	List<String> inputs=new ArrayList<String>();
	@Given("Click the Travel Insurance")
	public void click_the_travel_insurance() throws IOException, InterruptedException {
		
		inputs=ExcelforInsurance.ReadExcel();
    	Travelinsurance1 ti=new Travelinsurance1(driver);
		ti.Travel();
	}

	@When("Fill the details")
	public void fill_the_details() throws InterruptedException, IOException {
		inputs=ExcelforInsurance.ReadExcel();
		Travelinsurance1 ti=new Travelinsurance1(driver);
		ti.Country();
		ti.DatePick();
		ti.PeopleTravelling();
		ti.ContactDetails(inputs.get(0));
	}

	@Then("Get Insurance Plan")
	public void get_insurance_plan() throws InterruptedException, IOException {
		inputs=ExcelforInsurance.ReadExcel();
		Travelinsurance1 ti=new Travelinsurance1(driver);
		ti.InsurancePlans();
	}

	@Then("Click PolicyBazaar Logo")
	public void click_policy_bazaar_logo() {
		Travelinsurance1 ti=new Travelinsurance1(driver);
		ti.PolicyBazaar();
	}

	@Given("Click the Car Insurance")
	public void click_the_car_insurance() throws IOException {
		inputs=ExcelforInsurance.ReadExcel();
  		CarInsurance1 CI=new CarInsurance1(driver);
	   
	}

	@When("Fill the Car details")
	public void fill_the_car_details() throws IOException {
		inputs=ExcelforInsurance.ReadExcel();
  		CarInsurance1 CI=new CarInsurance1(driver);
  		CI.Car();
  		CI. BuyNewCar();
	   
	}

	@Then("Enter Valid Mail")
	public void enter_valid_mail() throws IOException, InterruptedException {
		inputs=ExcelforInsurance.ReadExcel();
  		CarInsurance1 CI=new CarInsurance1(driver);
  		CI.City();
  		
  		CI.CarRegistration();
  		CI.SelectBrand();
  		CI.SelectModel();
  		CI.EngineType();
  		CI.FuelCapacity();
  	
  		CI.Name(inputs.get(1));
  		CI.Mail(inputs.get(2));
  		Thread.sleep(2000);
  	
  		CI.PhnNum("8867564311");
  	//inputs.get(3)	
  		CI. Message();
  		CI.CrctMail(inputs.get(7));
    	
  		CI.CarClick();
	   
	}

	@Then("Get Car Quote")
	public void get_car_quote() throws IOException {
		inputs=ExcelforInsurance.ReadExcel();
  		CarInsurance1 CI=new CarInsurance1(driver);
  		
    	CI.Coverage();
    	
    	CI.Qoute();
	}

	@Given("Click the Home and HealthInsurance")
	public void click_the_home_and_health_insurance() throws IOException, InterruptedException {
		inputs=ExcelforInsurance.ReadExcel();
		HealthInsurance1 HI=new HealthInsurance1(driver);
		HI.HealthInsurance2();
	}

	@When("Fill the Health details")
	public void fill_the_health_details() throws IOException, InterruptedException {
		inputs=ExcelforInsurance.ReadExcel();
		HealthInsurance1 HI=new HealthInsurance1(driver);
		HI.CityName(inputs.get(4));
		HI.Fullname(inputs.get(5));
		HI.MbleNum(inputs.get(6));
		HI.Details();
	}

	@Then("Get Health Insurance Plan")
	public void get_health_insurance_plan() throws IOException, InterruptedException {
		inputs=ExcelforInsurance.ReadExcel();
		HealthInsurance1 HI=new HealthInsurance1(driver);
		HI.PlanDetails();
	
		ExcelforInsurance.excel();
	}
}
