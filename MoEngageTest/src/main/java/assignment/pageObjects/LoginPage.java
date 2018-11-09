package assignment.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.assignment.Baseutils.BasePage;

public class LoginPage extends BasePage {
	
	
	private By txtUserName=By.id("signin-email");
	private By txtPwd=By.id("signin-password");
	private By btnLogin=By.xpath("//span[text()='Login']");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public LoginPage enterUserName(String userName){
		
		safeType(txtUserName, userName);
		log("Entered User Name");
		return this;
	}
	
	public LoginPage enterPassword(String passWord){
		safeType(txtPwd, passWord);
		log("Entered Password");
		return this;
	}
	
	public HomePage clickLogin(){
		safeClick(btnLogin);
		log("Clicked on login button");
		return new HomePage(driver);
		
	}
	
	

}
