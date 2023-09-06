package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	PomLogin log;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initsetup() throws InterruptedException 
	{
		initiate();
		Thread.sleep(3000);
		screenshots("Login");
		
		log=new PomLogin();
		
	}
	
@Test(priority=1)
public void Title()
{
	String actual=log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual, "OrangeHRM");
}

@DataProvider
public Object[][] Details()
{
	Object[][] result=ExcelSheet.readdata("Sheet1");
	return result;
}

@Test(priority=2, dataProvider="Details")
public void login(String name, String password) throws InterruptedException 
{
	Thread.sleep(5000);
	log.typeusername(name);
	log.typepassword(password);
	//log.clickbtn();
	Thread.sleep(5000);
}


@AfterMethod
public void close()
{
	driver.close();
}
}
