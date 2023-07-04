package actitime.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;



public class BaseClass {
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	public CommonUtility cu=new CommonUtility();
	public static WebDriver listenerdriver;
	@BeforeClass
	public void launchBrowser()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		listenerdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url,String user,String pass) throws IOException
	{
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.name("pwd")).sendKeys(pass);
		driver.findElement(By.id("loginButton")).click();
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
		//driver.findElement(By.id("DiscardChangesButton")).click();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	

}
