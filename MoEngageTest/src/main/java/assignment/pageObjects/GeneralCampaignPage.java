package assignment.pageObjects;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

import com.assignment.Baseutils.BasePage;

public class GeneralCampaignPage extends BasePage {

	public enum Platform {
		Android, iOS, Windows, Web
	}
	public UserBehaviourTabPage UserBehaviourTabPage;
	private By txtName = By.xpath("//input[@placeholder='Campaign Name']");
	private By chkPlatform = By.xpath("//span[text()='{1}']/../../div[1]");
	private By radioTargetAudience = By.xpath("//md-radio-button[@aria-label='{1}']/div[1]");
	private By tabTargetAudience = By.xpath("//label[text()='{1}']");
	private By btnAddAttribute = By.xpath("(//span[contains(text(), 'Add attribute')])[{1}]");
	

	public GeneralCampaignPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public UserBehaviourTabPage getUserBehaviourTabPage(){
		return new UserBehaviourTabPage();
	}
	
	
	public GeneralCampaignPage enterCampaignName(String name) {
		safeType(txtName, name);
		log("Name Entered");
		return this;
	}

	public GeneralCampaignPage selectPlatform(Platform platform) {

		switch (platform) {
		case Android:
			chkPlatform = replaceValues(chkPlatform, "Android");
			selectCheckBox(chkPlatform, true);
			break;
		case iOS:
			chkPlatform = replaceValues(chkPlatform, "iOS");
			selectCheckBox(chkPlatform, true);
			break;

		case Windows:
			chkPlatform = replaceValues(chkPlatform, "Windows");
			selectCheckBox(chkPlatform, true);
			break;

		case Web:
			chkPlatform = replaceValues(chkPlatform, "Web");
			selectCheckBox(chkPlatform, true);
			break;
		}
		return this;

	}

	public GeneralCampaignPage selectTargetAudience(String targetAudience) {
		radioTargetAudience = replaceValues(radioTargetAudience, targetAudience);
		safeClick(radioTargetAudience);
		log("Selected :" + targetAudience);
		return this;

	}

	public Object navigateTotab(String tab) {
		tabTargetAudience = replaceValues(tabTargetAudience, tab);
		if (tab.equals("User Behavior"))
			safeClick(tabTargetAudience);
		return new UserBehaviourTabPage();

	}

	public class UserBehaviourTabPage {
		/* //Locators */
		private By selectUserAction = By.xpath("(//select[@data-placeholder='Select User Actions']/..)[{1}]");
		private By txtSearchText = By.xpath("//li[text()='{1}']");
		private By selectExecution = By.xpath("(//select[contains(@ng-model,'execution')])[{1}]");
		private By txtTimes = By.xpath("(//input[@type='number'])[{1}]");
		private By selectPrimaryTime = By.xpath("(//select[contains(@ng-model,'primary_time_range')])[{1}]");
		private By selectdate = By.xpath("//input[@placeholder='Click to add']");
		private By selectAttribute = By.xpath("(//select[@data-placeholder='Select an attribute']/..)[{1}]");
		private By selectOptforAttribute= By.xpath("(//select[contains(@ng-model,'operator_name')])[{1}]");
		private By txtAttributeVal=By.xpath("(//input[contains(@ng-model,'attribute')])[{1}]");
		private By btnNext=By.linkText("Next");
		private By txtMsgTitle=By.xpath("//textarea[@placeholder='Enter message title']");
		private By btnEnableFallBack=By.xpath("//md-switch[@aria-label='Enable Fallback Message']/div/div[2]/div");
		private By txtMsgTitle_Fallback=By.xpath("//span[contains(text(),'Fallback Message')]/../../../../..//textarea[@placeholder='Enter message title']");
		private By txtMsgFallBack=By.xpath("//span[contains(text(),'Fallback Message')]/../../../../..//textarea[@placeholder='Enter message']");
		private By lblRichContent=By.xpath("//span[contains(text(),'Fallback Message')]/../../../../..//label[text()='Rich content']/../i");
		private By selectContent= By.xpath("(//select[contains(@ng-model,'WidgetName')])[last()]");
		private By txtEnterCouponCode=By.xpath("//input[@placeholder='Enter coupon code']");
		private By lblAction_primaryMsg=By.xpath("(//span[contains(text(),'Primary Message')]/../../../../../descendant::label[text()='Actions']/../i)[1]");
		private By selectDefaultAction=By.xpath("//span[contains(text(),'Primary Message')]/../../../../..//select[contains(@ng-model,'actionArray')]");
		private By selectScreenName=By.xpath("//span[contains(text(),'Primary Message')]/../../../../..//select[@data-placeholder='Select a screen name']/..");
		private By txtName_key=By.xpath("(//div[contains(text(),'Additional Key Value pairs ')]/..//input[@placeholder='Name'])[last()]");
		private By txtData_Value=By.xpath("(//div[contains(text(),'Additional Key Value pairs ')]/..//input[@placeholder='Data'])[last()]");
		private By btnCreateCampaign=By.linkText("Create Campaign");
		/* Methods */
		public UserBehaviourTabPage clickSelectUserBehaviorArrow(int filterNumber) {
			selectUserAction = replaceValues(selectUserAction, Integer.toString(filterNumber));
			scrollIntoView(selectUserAction);
			waitForPage(2);
			safeClick(selectUserAction);
			waitForPage(2);
			return this;

		}

		public UserBehaviourTabPage enterSearchtext(String searchVal) {
			txtSearchText = replaceValues(txtSearchText,searchVal);
			safeClick(txtSearchText);
			return this;

		}

		public UserBehaviourTabPage selectExecutionType(String input, int filterNumber) {
			selectExecution = replaceValues(selectExecution, Integer.toString(filterNumber));
			selectValuesFromDrpDwn(selectExecution, input);
			return this;
		}

		public UserBehaviourTabPage enterTimes(String input, int filterNumber) {
			txtTimes = replaceValues(txtTimes, Integer.toString(filterNumber));
			safeType(txtTimes, input);
			return this;
		}

		public UserBehaviourTabPage selectPrimeTime(String input, int filterNumber) {
			selectPrimaryTime = replaceValues(selectPrimaryTime, Integer.toString(filterNumber));
			selectValuesFromDrpDwn(selectPrimaryTime, input);
			return this;
		}

		public UserBehaviourTabPage selectDate(String date) {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("document.getElementsByTagName('input')[3].removeAttribute('readonly')");
			Actions act=new Actions(driver);
			act.sendKeys(driver.findElement(selectdate), date);
			safeType(selectdate, date);
			return this;
		}

		public UserBehaviourTabPage clickAddAttribute(int filterNumber) {
			btnAddAttribute = replaceValues(btnAddAttribute, Integer.toString(filterNumber));
			safeClick(btnAddAttribute);
			waitForPage(3);
			return this;
		}

		public UserBehaviourTabPage clickSelectUserAttributeArrow(int filterNumber,String value) {
			selectAttribute = replaceValues(selectAttribute, Integer.toString(filterNumber));
			safeClick(selectAttribute);
			waitForPage(3);
			safeClick(By.xpath("//li[text()='"+value+"']"));
			return this;

		}
		
		public UserBehaviourTabPage selectOptionAddAttribute(String input, int filterNumber) {
			selectOptforAttribute = replaceValues(selectOptforAttribute, Integer.toString(filterNumber));
			selectValuesFromDrpDwn(selectOptforAttribute, input);
			return this;
		}
		
		
		public UserBehaviourTabPage enterAttributeVal(String input, int filterNumber) {
			txtAttributeVal = replaceValues(txtAttributeVal, Integer.toString(filterNumber));
			safeType(txtAttributeVal, input);
			return this;
		}
		
		public UserBehaviourTabPage clickNext(){
			safeClick(btnNext);
			return this;
		}
		
		public UserBehaviourTabPage enterMessageTitle(String message){
			safeType(txtMsgTitle, message);
			waitForPage(2);
			safeClick(By.linkText("Name"));
			return this;
			
			
		}
		
		public UserBehaviourTabPage enableFallBackMsg(boolean flag){
			if (true)
			btnEnableFallBack = By.xpath("//md-switch[@aria-label='Enable Fallback Message']/div/div[2]/div");
			scrollIntoView(btnEnableFallBack);
			safeClick(btnEnableFallBack);
			waitForPage(2);
			return this;
		}
		
		public UserBehaviourTabPage enterMessageTitleFallback(String message){
			safeType(txtMsgTitle_Fallback, message);
			waitForPage(2);
		
			return this;
		}
		
		public UserBehaviourTabPage enterMessageFallback(String message){
			safeType(txtMsgFallBack, message);
			waitForPage(2);
		
			return this;
		}
		
		public UserBehaviourTabPage selectRichContent(){
			safeClick(lblRichContent);
			waitForPage(1);
			return this;
		}
		
		public UserBehaviourTabPage selectContent(String value){
			selectValuesFromDrpDwn(selectContent, value);
			waitForPage(2);
			return this;
		}
		
		public UserBehaviourTabPage enterCouponCode(String couponCode){
			safeType(txtEnterCouponCode, couponCode);
			return this;
			
		}
		
		
		public UserBehaviourTabPage clickAction_PrimaryMsg(){
			System.out.println("44");
			try {
				scrollIntoView(lblAction_primaryMsg);
				safeClick(lblAction_primaryMsg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPage(1);
			return this;
		}
		
		public UserBehaviourTabPage SelectDefaultAction_Primarymsg(String text){
			selectValuesFromDrpDwn(selectDefaultAction, text);
			waitForPage(2);
			return this;
			
		}
		
		public UserBehaviourTabPage selectScreenName(String value){
			safeClick(selectScreenName);
			waitForPage(1);
			safeClick(By.xpath("//li[text()='"+value+"']"));
			return this;
			
		}
		
		public UserBehaviourTabPage enterKeyValue(String key,String Value){
			safeType(txtName_key, key);
			safeType(txtData_Value, Value);
			return this;
			
		}
		
		public UserBehaviourTabPage addKeyValuePairBtn(){
			safeClick(By.xpath("(//div[contains(text(),'Additional Key Value pairs ')]/../div/div[4])[last()]"));
			return this;
		}
		
		
		public UserBehaviourTabPage enterTime(int hour,int min){
			 Calendar cal = Calendar.getInstance();
			 cal.add(Calendar.MINUTE, 10);
			 cal.get(Calendar.HOUR);
			safeType(By.xpath("//input[@ng-model='hours']"), Integer.toString(cal.get(Calendar.HOUR)));
			safeType(By.xpath("//input[@ng-model='minutes']"), Integer.toString(cal.get(Calendar.MINUTE)));
			
			return this;
			
		}
		
		public UserBehaviourTabPage clickCreatecampaign(){
			safeClick(btnCreateCampaign);
			return this;
			
		}
		
		
	}
	
	
	
	
	

}
