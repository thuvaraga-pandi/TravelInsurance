package TestFunction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import BaseTest.Basetest;
import PageObjectModel.CarInsurance1;
import PageObjectModel.HealthInsurance1;
import PageObjectModel.Travelinsurance1;
import Utils.ExcelforInsurance;
import Utils.ScreenShots;


public class TravelInsuranceStudent extends Basetest{
	public static String path;
	
	List<String> inputs=new ArrayList<String>();
    @Test (priority=0)
	public void TravelInsuranceStudent1() throws InterruptedException, IOException {
    	logger.info("**********Starting of TravelInsurance**********");
		inputs=ExcelforInsurance.ReadExcel();
    	Travelinsurance1 ti=new Travelinsurance1(driver);
		ti.Travel();
		ti.Country();
		ti.DatePick();
		ti.PeopleTravelling();
		ti.ContactDetails(inputs.get(0));
		ti.InsurancePlans();
		logger.info("TravelInsurance for student was Taken");
		path=ScreenShots.screenShot("TravelInsurancePlan", driver);
		ti.PolicyBazaar();
		logger.info("**********Ending of TravelInsurance**********");
		
	}

    @Test (priority=1)
    public void MainCarInsurance() throws IOException, InterruptedException {
    	inputs=ExcelforInsurance.ReadExcel();
  		CarInsurance1 CI=new CarInsurance1(driver);
  		logger.info("**********Starting of TravelInsurance**********");
//  		CI.Policy();
  		CI.Car();
  		logger.info("Clicked on CarInsurance");
  		CI. BuyNewCar();
  		logger.info("Clicked on BuyNewCar");
  		
  		CI.City();
  		logger.info("Clicked on BuyNewCar");
  		CI.CarRegistration();
  		CI.SelectBrand();
  		CI.SelectModel();
  		CI.EngineType();
  		CI.FuelCapacity();
  		logger.info("Filled  CarDetails ");
  		CI.Name(inputs.get(1));
  		CI.Mail(inputs.get(2));
  		Thread.sleep(2000);
  		path=ScreenShots.screenShot("ErrorMsg", driver);
  		CI.PhnNum("8867564311");
  	//inputs.get(3)	
  		CI. Message();
//  		CI.CrctMail(inputs.get(7));
//  		CI.CarClick();
  		logger.info("**********Ending of TravelInsurance**********");
//  		CI.Policy();//changes
  	  
    }
    @Test(priority=2)
    public void ValidUser() throws IOException, InterruptedException {
    	logger.info("**********Starting of TravelInsurance**********");
    	CarInsurance1 CI=new CarInsurance1(driver);
    	CI.CrctMail(inputs.get(7));
    	path=ScreenShots.screenShot("ValidMail", driver);
  		CI.CarClick();
  		logger.info("Filled Valid Inputs");
  		logger.info("**********Ending of TravelInsurance**********");
    }
    @Test(priority=3)
    public void CarPlanQoute() throws IOException {
    	logger.info("**********Starting of TravelInsurance**********");
    	CarInsurance1 CI=new CarInsurance1(driver);
    	CI.Coverage();
    	logger.info("CarQoute was Taken");
    	path=ScreenShots.screenShot("CarQoute", driver);
    	CI.Qoute();
    	
    	logger.info("**********Ending of TravelInsurance**********");
    }
    @Test (priority=4)
	public void PolicyBazaarInsurance() throws InterruptedException, IOException {
    	logger.info("**********Starting of TravelInsurance**********");
    	inputs=ExcelforInsurance.ReadExcel();
	HealthInsurance1 HI=new HealthInsurance1(driver);
	HI.HealthInsurance2();
	HI.CityName(inputs.get(4));
	HI.Fullname(inputs.get(5));
	HI.MbleNum(inputs.get(6));
	HI.Details();
	HI.PlanDetails();
	logger.info("HealthInsurance was Taken");
	path=ScreenShots.screenShot("HealthInsurance", driver);
	ExcelforInsurance.excel();
	logger.info("**********Ending of TravelInsurance**********");
	
	}
}
