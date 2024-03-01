package BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Basetest {
	public WebDriver driver;
	public Logger logger;
	Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
	public void openApp(String os,String browser) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		FileReader file = new FileReader(".//src/test/resources/Config.properties");
		p = new Properties();
		p.load(file);

		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabalities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
				return;
			}
			//browser
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-blink-features=AutomationControlled");
				option.addArguments("--disable-notifications");
				capabalities.setBrowserName("chrome");
				capabalities.setCapability(ChromeOptions.CAPABILITY, option);				
			}
			else if(browser.equalsIgnoreCase("edge")) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--disable-blink-features=AutomationControlled");
				options.addArguments("--disable-notifications");
				capabalities.setBrowserName("MicrosoftEdge");
				capabalities.setCapability(EdgeOptions.CAPABILITY, options);
			}
			else {
				System.out.println("no matching browser .....");
				return;
			}
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-blink-features=AutomationControlled");
				option.addArguments("--disable-notifications");
				driver = new ChromeDriver(option);
				logger.info("Chrome browser opened successfully");
			}
			else if(browser.equalsIgnoreCase("edge")){
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--disable-blink-features=AutomationControlled");
				options.addArguments("--disable-notifications");
				driver = new EdgeDriver(options);
				logger.info("Edge browser opened successfully");
			}
			else {
				System.out.println("no matching browser......");
				logger.info("no matching browser......");
				return;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
