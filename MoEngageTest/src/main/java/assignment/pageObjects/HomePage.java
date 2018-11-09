package assignment.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.assignment.Baseutils.BasePage;

public class HomePage extends BasePage {

	private By btnCreateCampaign = By.xpath("//button/span[contains(text(),'CREATE CAMPAIGN')]");
	private By linkPushcampaign = By.xpath("//a/span[text()='{1}']");

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public HomePage clickCreateCampaign() {
		safeClick(btnCreateCampaign);
		log("Clicked on Create campaign");
		return this;
	}

	public CreateCampaignPage selectCampaignType(String campainType) {
		linkPushcampaign = replaceValues(linkPushcampaign, campainType);
		safeClick(linkPushcampaign);
		log("Clicked on :" + campainType);
		return new CreateCampaignPage(driver);

	}

}
