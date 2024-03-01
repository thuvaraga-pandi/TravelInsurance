package PageObjectModel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utils.ScreenShots;

public class CarInsurance1 extends Basepage {
	public static String PlanQoute;
	public CarInsurance1(WebDriver driver) {
		super(driver);
	}
	//PolicyBazaar
	@FindBy(xpath ="//a[@href=\'https://www.policybazaar.com/\']")
	WebElement PolicyBazar;
	//carInsurance
	@FindBy(xpath ="(//div[@class='shadowHandlerBox'])[4]")
	WebElement carInsurance;
	//buynewcar
	@FindBy(xpath ="//a[contains(text(),'Buying a new car? Click here')]")
	WebElement buynewcar;
	//Chennai
	@FindBy(xpath ="//span[@id='spn6']")
	WebElement SelectCity;
	//Registration
	@FindBy(xpath ="//span[contains(text(),'TN01')]")
	WebElement Registration;
	//Brand
	@FindBy(xpath ="//span[@class='tata']")
	WebElement Brand;
	//Model
	@FindBy(xpath ="//b[contains(text(),'ALTROZ')]")
	WebElement Model;
	//Petrol
	@FindBy(xpath ="//span[@id='Petrol']")
	WebElement Petrol;
	//PetrolCapacity
	@FindBy(xpath ="//b[contains(text(),'XE Petrol (1199 cc)')]")
	WebElement PetrolCapacity;
	//Fullname
	@FindBy(xpath ="//input[@id='name']")
	WebElement Fullname;
	//Email
	@FindBy(xpath ="//input[@id='email']")
	WebElement Email;
	//MbleNum
	@FindBy(xpath ="//input[@id='mobileNo']")
	WebElement MbleNum;
	//ErrorMsg
	@FindBy(xpath ="//div[@class='msg-error show']")
	WebElement ErrorMsg;
	//carclick
	@FindBy(xpath="//button[@id='btnLeadDetails']")
	WebElement carSub;
	
	//Cardelivary
	@FindBy(xpath="//button[@class='blueTextButton underline']")
	WebElement Cardelivary;
	//Exshowroom
	
    @FindBy(xpath="//button[@class='blueTextButton underline']")
		WebElement Exshowroom;
    //refresh
    @FindBy(xpath="//h2[text()='Refresh the page']")
	WebElement refresh;
    //CrossBtn
    @FindBy(xpath="//div[@class='crossBtn']")
   	WebElement CrossBtn;
    //viewCoverage
    @FindBy(xpath="//*[@id=\"root\"]/section/div/div/div/div[2]/section/div[1]/div/div[1]/div[2]/div[2]/p")
   	WebElement VeiwCoverage;
    //PremiumPackage
    @FindBy(xpath="(//li[@class='tabItem '])[1]")
   	WebElement PremiumPackage;
    //PremiumPackage
    @FindBy(xpath="//div[@class='popupBox padding0 policyDetailPopup slideToLeft']")
   	WebElement PackagePlan;
    //CrossBtn
    @FindBy(xpath="//div[@class='crossBg']")
   	WebElement Exit;

	//Action
	//PolicyBazaar
	public void Policy() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PolicyBazar.click();
	}
	
	//carInsurance
	public void Car() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	carInsurance.click();
	}
	
   //BuyNewCar
	public void BuyNewCar() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	buynewcar.click();
	}
	
	 //City
	public void City() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	SelectCity.click();
	}
	//Registration
	public void CarRegistration() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Registration.click();
	}
	
	//brand
		public void SelectBrand() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Brand.click();
		}
   //Model
		public void SelectModel() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Model.click();
		}
	//Petrol
		public void EngineType() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Petrol.click();
		}
		
	//Petrol
		public void FuelCapacity() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			PetrolCapacity.click();	
		}
	//FullName
		public void Name(String name) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Fullname.sendKeys(name);	
		}
		//Email
				public void Mail(String email) {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					Email.sendKeys(email);	
				}	
		
		//MbleNum
		public void PhnNum(String num) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			MbleNum.sendKeys(num);	
		}
		
		//ErrorMsg
		public void Message() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String ErrorMsg1=ErrorMsg.getText();
			System.out.println(ErrorMsg1);
		}
		//Email
		public void CrctMail(String email) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Email.clear();	
			Email.sendKeys(email);
			Thread.sleep(2000);
			
				}	
		//carclick
		public void CarClick() throws InterruptedException {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",carSub );
//			Actions ac=new Actions(driver);
//			Thread.sleep(2000);
//			ac.moveToElement(carSub).click().build().perform();
//			carSub.click();
			Cardelivary.click();
			Exshowroom.click();
			try {
				Thread.sleep(3000);

				    if(refresh.isDisplayed()) {
				    	CrossBtn.click();
				    	Thread.sleep(5000);
				    }
				}catch(org.openqa.selenium.NoSuchElementException e){
					e.getStackTrace();
		}
		
		}	//CarDelivary
		public void Coverage()  {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			VeiwCoverage.click();
			PremiumPackage.click();

		
			
		}
		public void Qoute() {
			 PlanQoute=PackagePlan.getText();
			System.out.println(PlanQoute);
			Exit.click();
		}
		
		
}

