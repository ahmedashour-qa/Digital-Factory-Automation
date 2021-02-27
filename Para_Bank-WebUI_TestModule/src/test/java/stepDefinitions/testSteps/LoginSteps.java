package stepDefinitions.testSteps;

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


    public LoginSteps(Base base) {
        this.base = base;
    }

    @Given("A user in the home page")
    public void iInHomePage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("parabank"));
    }


    @When("user enter name and password in fields {string} {string}")
    public void enterUserNameAndPassword(String UserName, String Password) {
        landPage = new LandPage(base.driver);
        landPage.login(UserName, Password);
    }

    @And("click on the login button")
    public void clickOnTheLoginBtn() {
        landPage = new LandPage(base.driver);
        landPage.clickOnLoginBtn();
    }

    @Then("I'm in the home page")
    public void iMInTheHomePage() {
        Assert.assertTrue(base.driver.getCurrentUrl().contains("overview"));
    }

    @Then("System displays an error message says {string}")
    public void systemDisplaysAnErrorMessageSays(String ErrorMessage) {
        Assert.assertEquals(ErrorMessage, landPage.LoginError());
    }
}
