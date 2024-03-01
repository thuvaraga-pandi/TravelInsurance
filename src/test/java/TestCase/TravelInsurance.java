package TestCase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TravelInsurance {
	
	List<String> allHealthList=new ArrayList<String>();

	
	public static WebDriver driver;

	@Test (priority = 1)
	void Setup() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-blink-features=AutomationControlled");
 
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
//		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
	}
	@Test(priority = 2)
	void Travel() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement TravelBtn=driver.findElement(By.xpath("//i[@class='icon-bg homeIconsBg icon-bg-new ti']"));
		TravelBtn.click();
	}
	@Test (priority = 3)
	void Destinations() throws InterruptedException {
		WebElement CountryBtn=driver.findElement(By.xpath("//p[contains(text(),'United Kingdom')]"));
		CountryBtn.click();
		Thread.sleep(5000);
		WebElement NextBtn=driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		NextBtn.click();
	}
	@Test (priority = 4)
	void SelectDate() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Calender=driver.findElement(By.xpath("(//input[@placeholder='dd mmmm, yyyy'])[1]"));
		Calender.click();
//		Thread.sleep(2000);
		String month_year="March 2024";
		String startdate="22";
		
		while(true) {
			String month=driver.findElement(By.xpath("(//h6[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline'])[1]")).getText();
			//*[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline'])[1]
			if(month.equals(month_year)) {
				break;
			}
			else {
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]")).click();
			}
			List<WebElement> datepicker1 = driver.findElements(By.xpath("//*[@class='MuiPickersDateRangeDay-root']"));
			for(WebElement element:datepicker1) {
				String date=element.getText();
				if(date.equals(startdate)) {
					element.click();
					break;
				}
			}
		}
//		WebElement Calender1=driver.findElement(By.xpath("(//input[@placeholder='dd mmmm, yyyy'])[2]"));
//		Calender1.click();
		Thread.sleep(3000);
		String enddate="12";
		String month_year1="April 2024";

		while(true) {
			String month=driver.findElement(By.xpath("(//*[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline'])[1]")).getText();
			if(month.equals(month_year1)) {
				break;
			}
			else {
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]")).click();
			}

			List<WebElement> datepicker1 = driver.findElements(By.xpath("//*[@class='MuiPickersDateRangeDay-root']"));
			for(WebElement element:datepicker1) {
				String date=element.getText();
				if(date.equals(enddate)) {
					element.click();
					break;
				}

			}
			WebElement NxtBtn1=driver.findElement(By.xpath("//button[@class='travel_main_cta']"));
			NxtBtn1.click();
		}
		
		
	}
	@Test (priority = 5)
	void PeopleTravelling() {
		WebElement Count=driver.findElement(By.xpath("//label[contains(text(),'2')]"));
		Count.click();
	}
	@Test (priority=6)
	void StudentAge() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Age1=driver.findElement(By.xpath("//div[contains(text(),'Select age of traveller 1')]"));
		Age1.click();
		WebElement SelectAge1=driver.findElement(By.xpath("//label[contains(text(),'22 years')]"));
		SelectAge1.click();
		//label[contains(text(),'22 years')]
		WebElement Age2=driver.findElement(By.xpath("//div[contains(text(),'Select age of traveller 2')]"));
		Age2.click();
		WebElement SelectAge2=driver.findElement(By.xpath("//label[contains(text(),'21 years')]"));
		SelectAge2.click();
		WebElement NextBtn=driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		NextBtn.click();
	}
	@Test (priority=7)
	void Medical() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement MedicalCheck=driver.findElement(By.xpath("//label[contains(text(),'No')]"));
		MedicalCheck.click();
		WebElement NextBtn=driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		NextBtn.click();
		
	}
	@Test (priority=8)
	void ContactDetails() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement PhnNum=driver.findElement(By.xpath("//input[@inputmode='numeric']"));
		PhnNum.sendKeys("8876123450");
		WebElement VeiwPlanBtn=driver.findElement(By.xpath("//button[contains(text(),'View plans')]"));
		VeiwPlanBtn.click();
	}
	@Test (priority=9)
	void Plans() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Select DropDwn=new Select(driver.findElement(By.xpath("//section[@class='newFilterSection sort']")));
//		DropDwn.selectByVisibleText("Premium low to high");
//		WebElement SortBy=driver.findElement(By.xpath("//p[@class='filter_name_heading']"));
//		SortBy.click();
		
//		Thread.sleep(5000);
//		List<WebElement> RadioBtn1=driver.findElements(By.xpath("//li[@class='options_box_wrapper__option']"));
//		RadioBtn1.get(5).click();
		
		driver.findElement(By.xpath("//input[@id='studentTrip']")).click();//Studentplan
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@id='Traveller_1']")).click();//Traveller1
		 driver.findElement(By.xpath("//input[@id='Traveller_2']")).click();//Traveller2
		 Select DropDwn=new Select(driver.findElement(By.xpath("//*[@id='feet']")));//dropdown
			DropDwn.selectByVisibleText("30 Days");
			driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();//apply
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[@class='filter_name_heading']")).click();//sort
			List<WebElement> RadioBtn=driver.findElements(By.xpath("//li[@class='options_box_wrapper__option']"));
			RadioBtn.get(1).click();
			
			//div[@class='quotesCard__planName']
			List<WebElement> Plan1=driver.findElements(By.xpath("//div[@class='quotesCard__planName']//div"));//plans
			List<String> Plans=new ArrayList<String>();
			for(int i=0;i<6;i=i+2) {
				Plans.add(Plan1.get(i).getText());
			}
			System.out.println(Plans);
			Thread.sleep(1000);
			
			List<WebElement> Price=driver.findElements(By.xpath("//p[@class='wrap-space ']"));//plans
			List<String> PriceAmt=new ArrayList<String>();
			for(int i=0;i<3;i++) {
				PriceAmt.add(Price.get(i).getText());
			}
			System.out.println(PriceAmt);
		 
		
		}
	//<------------------------car insurance------------------------------------------->
	@Test (priority=10)
	void CarInsurance() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@href=\"https://www.policybazaar.com/\"]")).click();//policybazaar
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='shadowHandlerBox'])[4]")).click();//carInsurance
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Buying a new car? Click here')]")).click();//buynewcar
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='spn6']")).click();//chennai
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'TN01')]")).click();//tn
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='tata']")).click();//brand
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//b[contains(text(),'ALTROZ')]")).click();//model
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='Petrol']")).click();//petrol
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//b[contains(text(),'XE Petrol (1199 cc)')]")).click();//PetrolCapacity
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//label[contains(text(),'Full Name')]")).click(); 
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("peter");//Fullname
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("adcfgh");//Email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='mobileNo']")).sendKeys("8765341200");//MbleNum
		
		String ErrorMsg=driver.findElement(By.xpath("//div[@class='msg-error show']")).getText();
		System.out.println(ErrorMsg);
//		<------------------------------------Screenshot---------------------------------------------------->
		
		driver.findElement(By.xpath("//a[@class='pb-logo']")).click();//policybazaar
		
		
	}
	//<--------------------------------Health Insurance---------------------------------------->
	@Test (priority=11)
	void HealthInsurance() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//i[@class='icon-bg homeIconsBg health-insurance'])[2]")).click();
		driver.findElement(By.xpath("//button[@id='step1ContinueBtn']")).click();
//		 Select DropDwn=new Select(driver.findElement(By.xpath("//select[@id='Self']")));//dropdown
//			DropDwn.selectByVisibleText("20 yr");
		driver.findElement(By.xpath("//select[@id='Self']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'22 yr')]")).click();
		driver.findElement(By.xpath("//button[@id='step2ContinueBtn']")).click();
		
		
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("chennai");//drpdwn	
			driver.findElement(By.xpath("//li[@class='active']")).click();
			driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("peter");//name
			driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("8765341200");//mblenum
			driver.findElement(By.xpath("//button[@id='step4ContinueBtn']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='radio_box_inner'])[7]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='corp_yes']")).click();
			driver.findElement(By.xpath("//input[@id='lessThan3']")).click();
			driver.findElement(By.xpath("//button[@id='viewPlansBtn']")).click();
			List<WebElement> allButton=driver.findElements(By.xpath("//span[@class='quotes_more_plans more ']"));
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			for(int j=0; j<allButton.size(); j++) {
				jse.executeScript("arguments[0].scrollIntoView()",allButton.get(j));
				jse.executeScript("arguments[0].click();",allButton.get(j));
				Thread.sleep(1000);
			}
			
			List<WebElement> allHealthInSuMenu=driver.findElements(By.className("quotes_rvmp_card__content__plan_header__name"));
			
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
	
	//<class name="TestFunction.InsuranceForCar"/>
//<class name="TestFunction.TC_HealthInsurance"/>	<class name="TestFunction.InsuranceForCar"/>
//<class name="TestFunction.TC_HealthInsurance"/>


