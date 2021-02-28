package stepDefinitions.testSteps;


import Pages.AccountPage;
import Pages.HomePage;
import Utilities.MethodHelper;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.testng.Assert;


public class AccountSteps {
    private Base base;
    MethodHelper methodHelper = new MethodHelper();
    HomePage homePage ;
    AccountPage accountPage;


    public AccountSteps(Base base) {
        this.base = base;
    }

    @When("Click on Accounts overview to display accounts details")
    public void clickOnAccountsOverviewToDisplayAccountsDetails() {
        homePage = new HomePage(base.driver);
        homePage.clickOnAccountsOverview();
    }

    @And("Select first account from  displayed accounts")
    public void selectFirstAccountFromDisplayedAccounts() {
        accountPage = new AccountPage(base.driver);
        accountPage.selectAccount();
    }

    @Then("Account details shall be displayed successfully")
    public void accountDetailsShallBeDisplayedSuccessfully() {
        accountPage = new AccountPage(base.driver);

        Assert.assertNotNull(accountPage.AccountNumberValue());
        Assert.assertNotNull(accountPage.AccountTypeValue());
        Assert.assertNotNull(accountPage.BalanceValue());
        Assert.assertNotNull(accountPage.AvailableBalanceValue());


    }

    @When("Click on Open new account to create a new account")
    public void clickOnOpenNewAccountToCreateANewAccount() {
        homePage = new HomePage(base.driver);
        homePage.clickOnOpenNewAccount();
    }

    @And("Select Account type from type list")
    public void selectAccountTypeFromTypeList() {
        accountPage = new AccountPage(base.driver);
        //accountPage.SelectAccountType();
    }

    @And("Click on Create button")
    public void clickOnCreateButton() {
        accountPage = new AccountPage(base.driver);
        accountPage.clickOnOpenNewAccBtn();
    }

    @Then("New Account shall be opened successfully")
    public void newAccountShallBeOpenedSuccessfully() {
        accountPage = new AccountPage(base.driver);
        accountPage.SelectAccountType();
        Assert.assertEquals("Account Opened!",accountPage.NewAccountMsg());
        Assert.assertNotNull(accountPage.NewAccountId());
    }
}
