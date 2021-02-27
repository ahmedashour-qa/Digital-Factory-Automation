package stepDefinitions.testSteps;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartModule extends Base {
    private Base base;

    public CartModule(Base base) {
        this.base = base;
    }

    @And("click on the home page button")
    public void clickOnTheHomePaeButton() {
        WebElement homepageBtn = base.driver.findElement(By.xpath("//a[@class='home']"));
        homepageBtn.click();
    }

    @When("Select {string} from the displayed products")
    public void selectFromTheDisplayedProducts(String product) {
        WebElement productName = base.driver.findElement(By.linkText(product));
        productName.click();
    }

    @And("click on the add to cart button")
    public void clickOnTheAddToCartButton() {
        WebElement addToCart = base.driver.findElement(By.xpath("//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"));
        addToCart.click();
    }

    @And("proceed to check out with {string}")
    public void proceedToCheckOutWith(String itemInCart) {
        WebElement btnproceed = base.driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
        btnproceed.click();

        WebElement proceedsecond = base.driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
        proceedsecond.click();
    }

    @And("proceed with a comment in the address {string}")
    public void proceedWithACommentInTheAddress(String comment) {
        WebElement CommentField = base.driver.findElement(By.tagName("textarea"));
        CommentField.sendKeys(comment);

        WebElement checkProceed = base.driver.findElement(By.name("processAddress"));
        checkProceed.click();
    }

    @And("proceed with the shipping cost with agree on the terms of service")
    public void proceedWithTheShippingCostWithAgreeOnTheTermsOfService() {
        WebElement checkOnAgree = base.driver.findElement(By.id("cgv"));
        checkOnAgree.click();

        WebElement proceedToCheck = base.driver.findElement(By.name("processCarrier"));
        proceedToCheck.click();
    }

    @And("the quantity i have selected is {string}")
    public void theQuantityIHaveSelectedIs(String ExpectedQuantity) {
        WebElement quantity = base.driver.findElement(By.xpath("//td[@class='cart_quantity text-center']/span"));
        String actualQuantity = quantity.getText();
        Assert.assertEquals(ExpectedQuantity, actualQuantity);

    }

    @And("the unit i have selected is {string}")
    public void theUnitIHaveSelectedIs(String ExpectedText) {
        WebElement productSelected = base.driver.findElement(By.xpath("//td[@class='cart_description']/p/a"));
        String actualText = productSelected.getText();
        Assert.assertEquals(ExpectedText, actualText);
    }

    @And("select the payment way is {string}")
    public void selectThePaymentWayIs(String expectedText) {
        WebElement payment = base.driver.findElement(By.className("bankwire"));
        payment.click();

        WebElement paymentWaySelected = base.driver.findElement(By.className("page-subheading"));
        String actualText = paymentWaySelected.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @And("click on the {string} button")
    public void clickOnTheButton(String arg0) {
        WebElement confirmBtn = base.driver.findElement(By.xpath("//p[@id='cart_navigation']/button"));
        confirmBtn.click();
    }

    @Then("the order has been created successfully with message {string}")
    public void theOrderHasBeenCreatedSuccessfully(String expectedResult) {
        WebElement confirmEmail = base.driver.findElement(By.xpath("//p[@class='cheque-indent']/strong"));
        String actualResult = confirmEmail.getText();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @And("Product shall be added to the cart")
    public void productShallBeAddedToTheCart() {
        WebElement ItemCounter = base.driver.findElement(By.xpath("//span[contains(text(),'1')]"));
        WebElement addToCart = base.driver.findElement(By.xpath("//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"));

        String actualItems = ItemCounter.getText();
        String buttonName = addToCart.getText();

        Assert.assertEquals("1", actualItems);
        Assert.assertEquals("REMOVE", buttonName);


    }

    @And("click on the Remove button")
    public void clickOnTheRemoveButton() {
        WebElement Remove = base.driver.findElement(By.xpath("//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"));
        Remove.click();
    }

    @Then("Product shall be removed from the cart")
    public void productShallBeRemovedFromTheCart() {
        WebElement addToCart = base.driver.findElement(By.xpath("//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"));
        String buttonName = addToCart.getText();
        Assert.assertEquals("ADD TO CART", buttonName);
    }
}
