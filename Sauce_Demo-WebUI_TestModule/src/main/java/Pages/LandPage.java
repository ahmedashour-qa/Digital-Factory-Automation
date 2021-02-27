package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandPage extends BasePage {

    public LandPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(name = "SubmitLogin")
    WebElement loginBtn;

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;

    @FindBy(xpath = "//div[@id='center_column']/div[1]//li")
    WebElement errorMessagelogin;

    @FindBy(xpath = "//div[@id='create_account_error']//li")
    WebElement errorMessageCreateAccount;

    //Actions needed login fields





    //Actions on create fields
    public void validateEmail(String email) {
        setTextElementText(emailCreate, email);
    }

    public void clickonCreateAnAccount() {
        clickButton(createAccountBtn);
    }

    /*public String getActualMessage(String page) {
        String actualErrorMessage = null;
        if (page.equals("login")) {
            actualErrorMessage = getTextElement(errorMessagelogin);
        } else {
            actualErrorMessage = getTextElement(errorMessageCreateAccount);
        }
        return actualErrorMessage;
    }*/


}
