package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }



    //Name
    @FindBy(id = "customer.firstName")
    WebElement customerFirstName;
    @FindBy(id = "customer.lastName")
    WebElement customerLastName;
    //Your Address Fields
    @FindBy(id = "customer.address.street")
    WebElement Address;
    @FindBy(id = "customer.address.city")
    WebElement City;
    @FindBy(id = "customer.address.state")
    WebElement State;
    @FindBy(id = "customer.address.zipCode")
    WebElement Zip_code;
    @FindBy(id = "customer.phoneNumber")
    WebElement Phone;
    @FindBy(id = "customer.ssn")
    WebElement SSN;

    @FindBy(id = "customer.username")
    WebElement userName;
    @FindBy(id = "customer.password")
    WebElement password;
    @FindBy(id = "repeatedPassword")
    WebElement passwordConfirmation;


    //Errors
    @FindBy(id = "customer.firstName.errors")
    WebElement customerFirstNameError;
    @FindBy(id = "customer.lastName.errors")
    WebElement customerLastNameError;
    @FindBy(id = "customer.address.street")
    WebElement addressError;
    @FindBy(id = "customer.address.city")
    WebElement cityError;
    @FindBy(id = "customer.address.state")
    WebElement stateError;
    @FindBy(id = "customer.address.zipCode")
    WebElement zip_codeError;
    @FindBy(id = "customer.ssn")
    WebElement SSNError;
    @FindBy(id = "customer.username.errors")
    WebElement userNameError;
    @FindBy(id = "customer.password")
    WebElement passwordError;
    @FindBy(id="repeatedPassword.errors")
    WebElement passwordConfirmationError;


    //Register Button
    @FindBy(xpath = "//tbody/tr[13]/td[2]/input[1]")
    WebElement registerBtn;






    public void SendPersonalInfo(String fName, String lName, String address, String city, String state, String zip_code, String phone, String ssn, String uName, String paswrd, String confirmation) {
        setTextElementText(customerFirstName, fName);
        setTextElementText(customerLastName, lName);
        setTextElementText(Address, address);
        setTextElementText(City, city);
        setTextElementText(State, state);
        setTextElementText(Zip_code, zip_code);
        setTextElementText(Phone, phone);
        setTextElementText(SSN, ssn);
        setTextElementText(userName, uName);
        setTextElementText(password, paswrd);
        setTextElementText(passwordConfirmation, confirmation);

    }
    public String getUNameErrMsg(){
        String UNameErr= getTextElement(userNameError);
        return UNameErr;
    }
    public String CustomerFirstNameError(){
        String CustomerFirstNameError = getTextElement(customerFirstNameError);
        return CustomerFirstNameError;
    }
    public String CustomerLastNameError(){
        String CustomerLastNameError = getTextElement(customerLastNameError);
        return CustomerLastNameError;
    }
    public String AddressError(){
        String AddressError = getTextElement(addressError);
        return AddressError;
    }
    public String CityError(){
        String CityError = getTextElement(cityError);
        return CityError;
    }
    public String StateError(){
        String StateError = getTextElement(stateError);
        return StateError;
    }
    public String Zip_codeError(){
        String Zip_codeError = getTextElement(zip_codeError);
        return Zip_codeError;
    }
    public String ssnError(){
        String ssnError = getTextElement(SSNError);
        return ssnError;
    }
    public String PasswordError(){
        String PasswordError = getTextElement(passwordError);
        return PasswordError;
    }
    public String PasswordConfirmationError(){
        String PasswordConfirmationError = getTextElement(passwordConfirmationError);
        return PasswordConfirmationError;
    }










    //Your address section actions
    /*public void getAddress(String Address, String City, String State, String Postcode, String Country) {
        setTextElementText(address, Address);
        setTextElementText(city, City);
        Select StateSelect = new Select(state);
        StateSelect.selectByVisibleText(State);
        setTextElementText(zip_code, Postcode);
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText(Country);
    }
*/
    public void getRestPhone(String Phone, String Alias) {
        setTextElementText(this.Phone, Phone);
        setTextElementText(SSN, Alias);
    }

    //Register Button Action
    public void register() {
        clickButton(registerBtn);
    }

    /*public String getActualErrorMessage() {
        String actualErrorMessage = getTextElement(errorMessage);
        return actualErrorMessage;
    }*/

}
