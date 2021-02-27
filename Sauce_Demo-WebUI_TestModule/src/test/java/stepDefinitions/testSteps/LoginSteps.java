package stepDefinitions.testSteps;

import Pages.SignInPage;
import Pages.LandPage;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginSteps extends Base {
    private Base base;
    LandPage landPage;
    SignInPage signInPage;

    public LoginSteps(Base base) {
        this.base = base;
    }

    @Given("A user in the home page")
    public void iInHomePage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("saucedemo"));
    }


    @When("user enter name and password in fields {string} {string}")
    public void enterUserNameAndPassword(String email, String password) {
        signInPage = new SignInPage(base.driver);
        signInPage.login(email, password);
    }

    @And("click on the login button")
    public void clickOnTheLoginBtn() {
        signInPage = new SignInPage(base.driver);
        signInPage.clickOnLoginBtn();
    }

    @Then("I'm in the home page")
    public void iMInTheHomePage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("inventory"));
    }

    @Then("In {string} system displays an error message says {string}")
    public void systemDisplaysAnErrorMessageSays(String page,String errorMessage) {
        signInPage = new SignInPage(base.driver);
        Assert.assertEquals(errorMessage,  signInPage.getActualMessage(page));
    }
}
