package BaseTest;
 
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
 
public class BaseClass {
	static WebDriver driver;
	static Properties p;
	static Logger logger;
	public static WebDriver initilizeBrowser() throws IOException  {
			 if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
				{
					switch(getProperties().getProperty("browser").toLowerCase())
					{
					case "chrome":

				        ChromeOptions option = new ChromeOptions();
				 	   option.addArguments("--disable-blink-features=AutomationControlled");
				 	   option.addArguments("--disable-notifications");
				 	   driver = new ChromeDriver(option);
				        break;
				    case "edge":
				    	 EdgeOptions options = new EdgeOptions();
					 	   options.addArguments("--disable-blink-features=AutomationControlled");
					 	   options.addArguments("--disable-notifications");
					 	   driver = new EdgeDriver(options);

				        break;
				    default:
				        System.out.println("No matching browser");
				        driver=null;
					}
				}
 
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		return driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static Properties getProperties() throws IOException {
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
		return p;
	}
	public static Logger getLogger() {
		logger=LogManager.getLogger();
		return logger;
	}
}