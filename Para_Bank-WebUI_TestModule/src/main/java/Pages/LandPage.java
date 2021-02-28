package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandPage extends BasePage {

    public LandPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(linkText = "Register")
    WebElement RegisterLnk;

    @FindBy(css = "div:nth-child(1) div:nth-child(2) form:nth-child(1) div.login:nth-child(2) > input.input")
    WebElement userNameField;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement passwordField;

    @FindBy(css = "div:nth-child(1) div:nth-child(2) form:nth-child(1) div.login:nth-child(5) > input.button")
    WebElement loginBtn;

	@FindBy(linkText="Log Out")
	private WebElement logoutLnk;



    //Errors
    @FindBy(css = "body:nth-child(2) div:nth-child(1) div:nth-child(3) div:nth-child(2) > p.error")
    WebElement loginError;

    //Actions needed login fields
    public void clickOnLoginBtn() {
        clickButton(loginBtn);
    }

    public void login(String email, String password) {
        setTextElementText(userNameField, email);
        setTextElementText(passwordField, password);

    }

    public void clickonRegister() {
        clickButton(RegisterLnk);
    }

    public String LoginError() {
        return getTextElement(loginError);
    }
    public void clickonLogout(){
        clickButton(logoutLnk);
    }


}


