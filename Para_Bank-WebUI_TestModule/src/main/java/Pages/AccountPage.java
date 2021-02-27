package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {



    public AccountPage(WebDriver driver) {
        super(driver);
    }




    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
    WebElement firstAccount;
    @FindBy(id="accountId")
    WebElement accountNumber;

    @FindBy(id="accountType")
    WebElement accountType;

	@FindBy(id="balance")
    WebElement balance;

	@FindBy(id="availableBalance")
	WebElement availableBalance;

	@FindBy(id="type")
	WebElement accountTypeOption;
	@FindBy(tagName="input")
    WebElement openNewAccBtn;

	@FindBy(css="div:nth-child(3) div:nth-child(2) div.ng-scope:nth-child(1) div.ng-scope > h1.title:nth-child(1)")
    WebElement newAccountHeader;

	@FindBy(id="newAccountId")
	WebElement newAccountId;











    //Actions
    public void selectAccount(){
        clickButton(firstAccount);
    }
    public String AccountNumberValue(){
       String AccountNumber =getTextElement(accountNumber);
        return AccountNumber;

    }
    public String AccountTypeValue(){
        String AccountType =getTextElement(accountType);
        return AccountType;
    }
    public String BalanceValue(){
        String Balance =getTextElement(balance);
        return Balance;
    }
    public String AvailableBalanceValue(){
        String AvailableBalance =getTextElement(availableBalance);
        return AvailableBalance;
    }
    public void SelectAccountType(){
        clickButton(accountTypeOption);
    }
    public void clickOnOpenNewAccBtn() {
        clickButton(openNewAccBtn);
    }
    public String NewAccountMsg(){
        String NewAccountMsg =getTextElement(newAccountHeader);
        return NewAccountMsg;
    }
    public String NewAccountId(){
        String NewAccountId = getTextElement(newAccountId);
        return NewAccountId;
    }
}


