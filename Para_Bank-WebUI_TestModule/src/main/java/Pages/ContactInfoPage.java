package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {

    public ContactInfoPage(WebDriver driver) {
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
	@FindBy(css="div.ng-scope:nth-child(1) div.ng-scope form.ng-valid.ng-dirty.ng-valid-parse table.form2:nth-child(1) tbody:nth-child(1) tr:nth-child(8) td:nth-child(2) > input.button")
	private WebElement updateProfileBtn;


//Actions

    public void SendContactInfo(String fName, String lName, String address, String city, String state, String zip_code, String phone) {
        setTextElementText(customerFirstName, fName);
        setTextElementText(customerLastName, lName);
        setTextElementText(Address, address);
        setTextElementText(City, city);
        setTextElementText(State, state);
        setTextElementText(Zip_code, zip_code);
        setTextElementText(Phone, phone);

    }
    public void ClickOnUpdateProfileBtn(){
        clickButton(updateProfileBtn);
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



}
