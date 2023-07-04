package actitime.genericLib;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	Actions act;
	Alert alt;
	Select s;
	WebDriverWait wait;
	public int getRandomNum() {
		Random r=new Random();
		int num=r.nextInt(10000);
		return num;
	}
	
	public void AlertAccept(WebDriver driver) {
		alt=driver.switchTo().alert();
		alt.accept();
	}
	public void AlertDismiss(WebDriver driver) {
		alt=driver.switchTo().alert();
		alt.dismiss();
	}
	public void AlertSendKeys(WebDriver driver,String text) {
		alt=driver.switchTo().alert();
		alt.sendKeys(text);
	}
	public String AlertGetText(WebDriver driver) {
		alt=driver.switchTo().alert();
		String text=alt.getText();
		return text;
	}
	public  void getSelectbyVisisbleText(WebElement dropdown,String visibleText)
	{
		s=new Select(dropdown);
		s.selectByVisibleText(visibleText);
	}
	public void getSelectbyIndex(WebElement dropdown,int index)
	{
		s=new Select(dropdown);
		s.selectByIndex(index);
	}
	public void getSelectbyValue(WebElement dropdown,String value)
	{
		s=new Select(dropdown);
		s.selectByValue(value);
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		act=new Actions(driver);
		act.doubleClick(element);
	}
	public void moveToElement(WebDriver driver,WebElement element)
	{
		act=new Actions(driver);
		act.moveToElement(element);
		
	}
	
	public void textToBePresentWait(WebDriver driver, By locator, String text)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
}
