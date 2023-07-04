package actitime.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;

public class MouseHandling extends BaseClass{
	@Test
	public void handleMouse()
	{
		WebElement task=driver.findElement(By.id("container_tasks"));
		cu.moveToElement(driver, task);
		cu.doubleClick(driver, task);
	}

}
