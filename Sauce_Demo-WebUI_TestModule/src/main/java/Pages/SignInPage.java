package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(id = "user-name")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/form[1]/h3[1]")
    WebElement errorMessagelogin;

    public void clickOnLoginBtn() {
        clickButton(loginBtn);
    }
    public void login(String email, String password) {
        setTextElementText(emailField, email);
        setTextElementText(passwordField, password);
    }

    public String getActualMessage(String page) {
        String actualErrorMessage = null;
        if (page.equals("login")) {
            actualErrorMessage = getTextElement(errorMessagelogin);
        } else {
            actualErrorMessage = null;
        }
        return actualErrorMessage;
    }
}
