package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Accounts Overview")
    WebElement accountsOverview;

	@FindBy(linkText="Open New Account")
    WebElement openNewAccount;
	@FindBy(linkText="Update Contact Info")
	private WebElement updateContactInfo;




    //Actions

    public void clickOnAccountsOverview(){
        clickButton(accountsOverview);
    }
    public void clickOnOpenNewAccount(){
        clickButton(openNewAccount);
    }
    public void clickOnUpdateContactInfo(){
        clickButton(updateContactInfo);
    }


}
