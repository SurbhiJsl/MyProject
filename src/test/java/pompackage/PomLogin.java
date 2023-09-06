package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass{
	
	//Object Repository
	@FindBy(name="username") WebElement Username;
	@FindBy(name="password") WebElement Password;
	@FindBy(css=".oxd-button") WebElement Loginbtn;
	

	//Initiate page elements
	public PomLogin()
	{
		PageFactory.initElements(driver,this);
	}
	public void typeusername(String name)
	{
		Username.sendKeys(name);
	}
	public void typepassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	  public void clickbtn()
	  { 
		  Loginbtn.click(); 
	  }
	  public String verify()
	  {
		  return driver.getTitle();
	  }
	 

}
