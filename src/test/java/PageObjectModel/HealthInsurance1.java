package PageObjectModel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HealthInsurance1 extends Basepage {
	public static List<String> allHealthList=new ArrayList<String>();
	public HealthInsurance1(WebDriver driver) {
		super(driver);
		}
	
		@FindBy(xpath ="//a[@href='https://www.policybazaar.com/']")
		WebElement PolicyBazar;
	//Hinsurance
		@FindBy(xpath ="(//i[@class='icon-bg homeIconsBg health-insurance'])[2]")
		WebElement Hinsurance;
	//Health
		@FindBy(xpath ="//button[@id='step1ContinueBtn']")
		WebElement Health;
	//Self
		@FindBy(xpath ="//select[@id='Self']")
		WebElement Self;
	//Year
		@FindBy(xpath ="//*[contains(text(),'22 yr')]")
		WebElement Year;
	//SubBtn
		@FindBy(xpath ="//button[@id='step2ContinueBtn']")
		WebElement SubBtn;
	//Citysendkey
		@FindBy(xpath ="//input[@id='city']")
		WebElement City;
	//Click
		@FindBy(xpath ="//li[@class='active']")
		WebElement Click;
	//Fullname
		@FindBy(xpath ="//input[@id='fullName']")
		WebElement Name;
	//mblenum
		@FindBy(xpath ="//input[@id='mobile']")
		WebElement mblenum;
	//Submit
		@FindBy(xpath ="//button[@id='step4ContinueBtn']")
		WebElement Submit ;
	//NoneofAbove
		@FindBy(xpath ="(//div[@class='radio_box_inner'])[7]")
		WebElement NoneofAbove;
	//Company
		@FindBy(xpath ="//input[@id='corp_yes']")
		WebElement Company;
	//OfficeInsurance
		@FindBy(xpath ="//input[@id='lessThan3']")
		WebElement OfficeInsurance;
	//VeiwPlan
		@FindBy(xpath ="//button[@id='viewPlansBtn']")
		WebElement VeiwPlan;
	//AllButton
		@FindBy(xpath ="//span[@class='quotes_more_plans more ']")
		List<WebElement> allButton;
	//AllHealth
		@FindBy(className ="quotes_rvmp_card__content__plan_header__name")
		List<WebElement> allHealthInSuMenu;	
		
		
		//Actions
		public void HealthInsurance2() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
			PolicyBazar.click();
			Thread.sleep(1000);
			Hinsurance.click();
			Thread.sleep(1000);
			Health.click();
			Thread.sleep(1000);
			Self.click();
			Thread.sleep(1000);
			Year.click();
			Thread.sleep(1000);
			SubBtn.click();
			Thread.sleep(1000);
		}
		
		//Data
		public void CityName(String Cname) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
			City.sendKeys(Cname);
			Thread.sleep(1000);
			Click.click();
		}
		//FullName
		public void Fullname(String name) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
			Name.sendKeys(name);
		}
		//MbleNum
		public void MbleNum(String Num) throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
			mblenum.sendKeys(Num);
			Thread.sleep(1000);
			Submit.click();
		}
		//Details
		public void Details() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
			NoneofAbove.click();
			Thread.sleep(1000);
			Company.click();
			Thread.sleep(1000);
			OfficeInsurance.click();
			Thread.sleep(1000);
			VeiwPlan.click();
			
		}
		//PlanDetails
		public void PlanDetails() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			JavascriptExecutor jse=(JavascriptExecutor)driver;
//			Thread.sleep(1000);
			for(int j=0; j<allButton.size(); j++) {
				jse.executeScript("arguments[0].scrollIntoView()",allButton.get(j));
				jse.executeScript("arguments[0].click();",allButton.get(j));

			}
			
			System.out.println(allHealthInSuMenu.size());
	
			for(int i=0; i<allHealthInSuMenu.size(); i++) {
				allHealthList.add(allHealthInSuMenu.get(i).getText());

			}
			System.out.println("-------------Health Insurance List-------------- ");

			for(int k=0; k<allHealthInSuMenu.size(); k++) {

				System.out.println(allHealthList.get(k));
			}
			
		}
		
		
		
		
		
		
}
