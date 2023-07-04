package actitime.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;

public class DropdownHandling extends BaseClass {
	@Test
	public void handleDropDown()
	{
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.xpath("//div[contains(text(),'configure actiTIME')]/preceding-sibling::div")).click();
		WebElement topgroupinglevel=driver.findElement(By.name("firstHierarchyLevelCode"));
		cu.getSelectbyVisisbleText(topgroupinglevel, "Product Line");		
		String text=driver.findElement(By.id("FormModifiedTextCell")).getText();
		System.out.println(text);
	}

}
