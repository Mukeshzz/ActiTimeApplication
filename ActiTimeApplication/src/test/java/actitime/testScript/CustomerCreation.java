package actitime.testScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import actitime.genericLib.BaseClass;

@Listeners(actitime.genericLib.ListenerImplementation.class)
public class CustomerCreation extends BaseClass {
	@Parameters({"name"})
	@Test
	public void CustomerCreate(String name) throws EncryptedDocumentException, IOException, InterruptedException {
		String customername=name;
		int num=cu.getRandomNum();
		customername=customername+num;
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.className("ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.className("newNameField")).sendKeys(customername);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("Customer creation is going");
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		cu.textToBePresentWait(driver, By.cssSelector(".titleEditButtonContainer>.title"), customername);
		String actualCustomerName=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
		assertEquals(customername, actualCustomerName);
		System.out.println("TC Pass");
		Reporter.log(actualCustomerName);
	}		
				
				
	}


