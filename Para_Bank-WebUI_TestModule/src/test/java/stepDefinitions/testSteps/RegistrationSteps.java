package stepDefinitions.testSteps;

import Pages.RegistrationPage;
import Pages.LandPage;
import Utilities.MethodHelper;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationSteps extends Base {
    private Base base;
    MethodHelper methodHelper = new MethodHelper();
    LandPage landPage;
    RegistrationPage registrationPage;

    public RegistrationSteps(Base base) {
        this.base = base;
    }

    @And("Redirected to the login page")
    public void redirectedToTheLoginPage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("authentication"));
    }

    @And("Click on Register link")
    public void clickOnRegisterLink() {
        landPage = new LandPage(base.driver);
        landPage.clickonRegister();
    }

    @And("Redirected to continue registration page")
    public void redirectedToContinueRegistrationPage() {
       Assert.assertTrue(base.driver.getCurrentUrl().contains("register"));
    }

    @And("click on Register button")
    public void clickOnRegisterButton() {
        registrationPage = new RegistrationPage(base.driver);
        registrationPage.register();
    }

    @Then("The account has been created successfully")
    public void TheAccountHasBeenCreatedSuccessfully() {
        WebElement welcomeMsg = base.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/p[1]"));
        String buttonName = welcomeMsg.getText();
        Assert.assertEquals("Your account was created successfully. You are now logged in.", buttonName);
    }

    @And("Fill all the required fields of personal information section {string} , {string}, {string} ,{string},{string},{string},{string},{string},{string},{string},{string}")
    public void fillAllTheRequiredFieldsOfPersonalInformationSection(String FName, String LName, String Address, String City, String State, String Zip_Code, String Phone, String SSN, String Username, String Password,String Confirmation) {
        registrationPage = new RegistrationPage(base.driver);
        registrationPage.SendPersonalInfo(FName, LName, Address, City, State, Zip_Code, Phone, SSN, Username, Password,Confirmation);
    }

    @Then("System displays an {string}beside username field")
    public void systemDisplaysAnBesideUsernameField(String ErrorMessage) {
        registrationPage = new RegistrationPage((base.driver));

        String ActualErr = registrationPage.getUNameErrMsg();
        Assert.assertEquals(ErrorMessage, ActualErr);
    }
    @Then("System displays an {string}beside {string}")
    public void systemDisplaysAnBeside(String field, String ErrorMessage) {
        registrationPage = new RegistrationPage((base.driver));

        switch (field) {
            case "First Name":
                Assert.assertEquals(ErrorMessage, registrationPage.CustomerFirstNameError());
                break;
            case "Last Name":
                Assert.assertEquals(ErrorMessage, registrationPage.CustomerLastNameError());
                break;
            case "Address":
                Assert.assertEquals(ErrorMessage, registrationPage.AddressError());
                break;
            case "City":
                Assert.assertEquals(ErrorMessage, registrationPage.CityError());
                break;
            case "State":
                Assert.assertEquals(ErrorMessage, registrationPage.StateError());
                break;
            case "Zip Code":
                Assert.assertEquals(ErrorMessage, registrationPage.Zip_codeError());
                break;
            case "SSN":
                Assert.assertEquals(ErrorMessage, registrationPage.ssnError());
                break;
            case "Username":
                Assert.assertEquals(ErrorMessage, registrationPage.getUNameErrMsg());
                break;
            case "Password":
                Assert.assertEquals(ErrorMessage, registrationPage.PasswordError());
                break;
            case "Confirm":
                Assert.assertEquals(ErrorMessage, registrationPage.PasswordConfirmationError());
                break;
        }

    }
}
