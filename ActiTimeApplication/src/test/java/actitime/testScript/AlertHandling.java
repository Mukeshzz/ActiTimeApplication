package actitime.testScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import actitime.genericLib.BaseClass;

public class AlertHandling extends BaseClass{
	String msg="Are you sure you want to cancel the Type of Work creation?";
	@Test
	public void handleAlert() throws EncryptedDocumentException, IOException
	{
	driver.findElement(By.className("popup_menu_button_settings")).click();
	driver.findElement(By.linkText("Types of Work")).click();
	driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
	driver.findElement(By.name("name")).sendKeys(du.getDataFromExcelSheet("Sheet4", 0, 1));
	driver.findElement(By.xpath("//td[@id='ButtonPane']/input[@type='button']")).click();
	String text=cu.AlertGetText(driver);
	System.out.println(text);
	assertEquals(msg, text);
	cu.AlertDismiss(driver);
	
	}
	}

