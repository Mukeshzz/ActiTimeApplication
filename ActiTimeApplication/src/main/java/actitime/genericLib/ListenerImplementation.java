package actitime.genericLib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
	String tcname=result.getName();
	TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerdriver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("./failTC/"+tcname+".png");
	try {
		FileUtils.copyFile(src, trg);	
	}
	catch(Exception e)
	{
		
	}
	
	}

}
