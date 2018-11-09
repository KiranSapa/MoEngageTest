package assignmentDemo.MoEngage;

import org.testng.annotations.Test;

import com.assignment.Baseutils.BaseTest;

import assignment.pageObjects.CreateCampaignPage;
import assignment.pageObjects.GeneralCampaignPage;
import assignment.pageObjects.GeneralCampaignPage.Platform;
import assignment.pageObjects.GeneralCampaignPage.UserBehaviourTabPage;
import assignment.pageObjects.HomePage;
import assignment.pageObjects.LoginPage;

public class Scenario1 extends BaseTest {
	/*TestData*/
	String userName=getTestInputData().getProperty("userName");
	String pwd=testInputData.getProperty("Password");
	String campaignType=testInputData.getProperty("campaignType");
	String campaign=testInputData.getProperty("General");
	String campaignName=testInputData.getProperty("campaignName");
	String targetAud=testInputData.getProperty("targetAud");
	String userBehaviourTab=testInputData.getProperty("userBehaviourTab");
	String searchText=testInputData.getProperty("searchText");
	String executionType=testInputData.getProperty("executionType");
	String primeTime=testInputData.getProperty("primeTime");
	String date=testInputData.getProperty("date");
	String platform=testInputData.getProperty("platform");
	
	
	
	
	@Test
	public void moEngageTest(){
		//Step 1 login 
		HomePage homePage=new LoginPage(driver).enterUserName(userName).enterPassword(pwd).clickLogin();
		//Step 2
		CreateCampaignPage createCampaignPage=homePage.clickCreateCampaign().selectCampaignType(campaignType);
		//step 3
		GeneralCampaignPage generalCampaignPage=createCampaignPage.createCampaign(campaign);
		//step 4
		generalCampaignPage.enterCampaignName(campaignName).selectPlatform(Platform.Android)
		.selectTargetAudience(targetAud).navigateTotab(userBehaviourTab);
	
		UserBehaviourTabPage userBehaviourTabPage=generalCampaignPage.getUserBehaviourTabPage();
		userBehaviourTabPage.clickSelectUserBehaviorArrow(1).enterSearchtext(searchText)
		.selectExecutionType(executionType, 1).enterTimes("2", 1).selectPrimeTime(primeTime, 1)
		.selectDate(date);	
		userBehaviourTabPage.clickAddAttribute(1).clickSelectUserAttributeArrow(1,platform).selectOptionAddAttribute("starts with", 1)
		.enterAttributeVal("and", 1).clickNext();
		//messaging tab
		userBehaviourTabPage.enterMessageTitle("@").enableFallBackMsg(true);
		userBehaviourTabPage.selectRichContent().selectContent("Coupon")
		.enterCouponCode("abcd").clickAction_PrimaryMsg().SelectDefaultAction_Primarymsg("Navigate to a screen")
		.selectScreenName("com.moengage.demoapp.DemoScreen");
		//Adding  key value
		userBehaviourTabPage.enterKeyValue("name1","data1").addKeyValuePairBtn()
		.enterKeyValue("name2", "data2").clickNext();
		//clicking on create campaign
		userBehaviourTabPage.clickCreatecampaign();
		
			
	}
	

}
