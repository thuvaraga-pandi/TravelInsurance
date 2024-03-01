package PageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ExcelforInsurance;

public class Travelinsurance1 extends Basepage {
	public static List<String> Plans=new ArrayList<String>();
	public static List<String> PriceAmt=new ArrayList<String>();
	public Travelinsurance1(WebDriver driver) {
		super(driver);
		}
//element
		@FindBy(xpath="//i[@class='icon-bg homeIconsBg icon-bg-new ti']")
		WebElement TravelBtn;

		@FindBy(xpath="//p[contains(text(),'United Kingdom')]")
		WebElement CountryBtn;
		
		
		@FindBy(xpath="//button[contains(text(),'Next')]")
		WebElement NextBtn;
		
		
		@FindBy(xpath="(//input[@placeholder='dd mmmm, yyyy'])[1]")
		WebElement Calender;
		
		
		@FindBy(xpath="(//h6[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline'])[1]")
		WebElement MonthName;
		
		//monnxt
		
		
		@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]")
		WebElement MonNext;
		//DatePicker
		@FindBy(xpath="//*[@class='MuiPickersDateRangeDay-root']")
		List<WebElement> DatePicker;

		//ENDDATE
		@FindBy(xpath="(//*[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline'])[1]")
		WebElement EndDate;
		
		//NextAfterdateselection
		@FindBy(xpath="//button[@class='travel_main_cta']")
		WebElement NxtBtn1;
		//Count
		@FindBy(xpath="//label[contains(text(),'2')]")
		WebElement Count;
		//Age1
		@FindBy(xpath="//div[contains(text(),'Select age of traveller 1')]")
		WebElement Age1;
		//SelectAge
		@FindBy(xpath="//label[contains(text(),'22 years')]")
		WebElement SelectAge1;
		//Age2
		@FindBy(xpath="//div[contains(text(),'Select age of traveller 2')]")
		WebElement Age2;
		//SelectAge2
		@FindBy(xpath="//label[contains(text(),'21 years')]")
		WebElement SelectAge2;
		//Nxtbtn2afterageselected
		@FindBy(xpath="//button[contains(text(),'Next')]")
		WebElement NxtBtn2;
		//MedicalCheck
		@FindBy(xpath="//label[contains(text(),'No')]")
		WebElement MedicalCheck;
		//MedicalNxt
		@FindBy(xpath="//button[contains(text(),'Next')]")
		WebElement NxtBtn3;
		//ContactDetails
		@FindBy(xpath="//input[@inputmode='numeric']")
		WebElement PhnNumber;
		//VeiwPlan
		@FindBy(xpath="//button[contains(text(),'View plans')]")
		WebElement VeiwPlanBtn;
		//StudentPlanRadioBtn
		@FindBy(xpath="//input[@id='studentTrip']")
		WebElement StudentPlanRadioBtn;
		//Traveller1
		@FindBy(xpath="//input[@id='Traveller_1']")
		WebElement Traveller1;
		//Traveller2
		@FindBy(xpath="//input[@id='Traveller_2']")
		WebElement Traveller2;
		//StudentDrpDwn
		@FindBy(xpath="//*[@id='feet']")
		WebElement DrpDwns;
		//Apply
		@FindBy(xpath="//button[contains(text(),'Apply')]")
		WebElement Apply;
		//Sort
		@FindBy(xpath="//p[@class='filter_name_heading']")
		WebElement Sort;
		//RadioBtnneed action
		@FindBy(xpath="//li[@class='options_box_wrapper__option']")
		List<WebElement> RadioBtns;
		//Plan
		@FindBy(xpath="//div[@class='quotesCard__planName']//div")
		List<WebElement> Plan;
	  //Pricesforplan
		@FindBy(xpath="//p[@class='wrap-space ']")
		List<WebElement> Prices;
		
		//By Variables
		By cout=By.xpath("//p[contains(text(),'United Kingdom')]");
		//PolicyBazaar
		@FindBy(xpath ="//a[@href=\'https://www.policybazaar.com/']")
		WebElement PolicyBazar;
		
		//Action
		
		public void Travel() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			TravelBtn.click();

			
			
		}
		public void Country() throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(cout));
Thread.sleep(2000);
			CountryBtn.click();
			Thread.sleep(2000);
			NextBtn.click();
		}
		//datepicker
		public void DatePick() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			Calender.click();
			String startdate="12";
			String month_year="April 2024";
			while(true) {
				String month=MonthName.getText();
				if(month.equals(month_year)) {
					break;
				}
				else {
					MonNext.click();
				}

				for(WebElement element:DatePicker) {
					String date=element.getText();
					if(date.equals(startdate)) {
						element.click();
						break;
					}
				}
			}
			String enddate="10";
			String month_year1="May 2024";

			while(true) {
				String month=EndDate.getText();
				if(month.equals(month_year1)) {
					break;
				}
				else {
					MonNext.click();
				}

				for(WebElement element:DatePicker) {
					String date=element.getText();
					if(date.equals(enddate)) {
						element.click();
						break;
					}

				}
			}
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", NxtBtn1);
			//NxtBtn1.click();
			
		}
		
		//PeopleTravelling
		public void PeopleTravelling() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Count.click();
			Age1.click();
			SelectAge1.click();
			Age2.click();
			SelectAge2.click();
			NxtBtn2.click();
			MedicalCheck.click();
			NxtBtn3.click();
			
			
			
			
			
		}
		
		//ContactDetails
		public void ContactDetails( String MbleNum) throws IOException {

			ExcelforInsurance.ReadExcel();
			PhnNumber.sendKeys(MbleNum);
			VeiwPlanBtn.click();
			
			
		}
		//Plans
		public void InsurancePlans() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(5000);
			StudentPlanRadioBtn.click();
			Thread.sleep(3000);
			Traveller1.click();
			Traveller2.click();
			Select DropDwn=new Select(DrpDwns);//dropdown
			DropDwn.selectByVisibleText("30 Days");
			Apply.click();
			Thread.sleep(3000);	
			Sort.click();
			List<WebElement> RadioBtn=RadioBtns;
			RadioBtn.get(1).click();
			List<WebElement> Plan1=Plan;//plans
		
			for(int i=0;i<6;i=i+2) {
				Plans.add(Plan1.get(i).getText());
			}
			System.out.println(Plans);
			Thread.sleep(1000);
			
			List<WebElement> Price=Prices;//plans
			
			for(int i=0;i<3;i++) {
				PriceAmt.add(Price.get(i).getText());
			}
			System.out.println(PriceAmt);
				
			
			
		}
		
		
		
		public void PolicyBazaar() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			PolicyBazar.click();
		}
		
		
		
		
		
		
		
		
	
}
