package stepDefinitions.testSteps;

import Pages.ContactInfoPage;
import Pages.HomePage;
import Pages.LandPage;
import Utilities.MethodHelper;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactInfoSteps {
    private Base base;
    MethodHelper methodHelper = new MethodHelper();
    ContactInfoPage contactInfoPage;
    HomePage homePage;
    public ContactInfoSteps(Base base) {
        this.base = base;
    }

    @When("Click on Update Contact Info to Update User Contact Info")
    public void clickOnUpdateContactInfoToUpdateUserContactInfo() {
        homePage = new HomePage(base.driver);
        homePage.clickOnUpdateContactInfo();
    }

    @And("Fill all the required fields of update profile section {string} , {string}, {string} ,{string},{string},{string},{string}")
    public void fillAllTheRequiredFieldsOfUpdateProfileSection(String FName, String LName, String Address, String City, String State, String Zip_Code, String Phone) {
        contactInfoPage=new ContactInfoPage(base.driver);
        contactInfoPage.SendContactInfo(FName,LName,Address,City,State,Zip_Code,Phone);

    }

    @And("User clicks on Update profile button")
    public void userClicksOnUpdateProfileButton() {
        contactInfoPage=new ContactInfoPage(base.driver);
        contactInfoPage.ClickOnUpdateProfileBtn();
    }

    @Then("Contact Info Shall be updated successfully")
    public void contactInfoShallBeUpdatedSuccessfully() {
        WebElement Update = base.driver.findElement(By.cssSelector("div:nth-child(3) div:nth-child(2) div.ng-scope:nth-child(1) div.ng-scope > p:nth-child(2)"));
        String UpdateAlrt = Update.getText();
        Assert.assertEquals(UpdateAlrt,"Your updated address and phone number have been added to the system.");
    }
}
