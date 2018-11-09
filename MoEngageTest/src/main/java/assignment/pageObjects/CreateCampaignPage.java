package assignment.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.assignment.Baseutils.BasePage;

public class CreateCampaignPage  extends BasePage{
	
	private By createCampaign=By.xpath("//span[text()='{1}']/../following-sibling::a");

	public CreateCampaignPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public GeneralCampaignPage createCampaign(String CampaignType){
		createCampaign=replaceValues(createCampaign, CampaignType);
		safeClick(createCampaign);
		log("Clicked on general campaign");
		return new GeneralCampaignPage(driver);
		
	}
	
	

}
