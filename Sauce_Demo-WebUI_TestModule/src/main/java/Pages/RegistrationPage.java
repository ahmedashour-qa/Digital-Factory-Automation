package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    //Fields of personal Info section
    //Gender Radio Button male or female
    @FindBy(id = "id_gender1")
    WebElement MrRadioBtn;
    @FindBy(id = "id_gender2")
    WebElement MrsRadioBtn;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;
    @FindBy(id = "customer_lastname")
    WebElement customerLastName;
    @FindBy(id = "passwd")
    WebElement password;

    //select  DOB from the Drop down
    @FindBy(id = "days")
    WebElement days;
    @FindBy(id = "months")
    WebElement months;
    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "newsletter")
    WebElement newsLetter;
    @FindBy(id = "optin")
    WebElement optin;

    //Your Address Fields
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "id_state")
    WebElement state;
    @FindBy(id = "postcode")
    WebElement postalCode;
    @FindBy(id = "id_country")
    WebElement country;
    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;
    @FindBy(id = "alias")
    WebElement alias;

    //Register Button
    @FindBy(id = "submitAccount")
    WebElement registerBtn;

    @FindBy(xpath = "//div[@id='center_column']//li")
    WebElement errorMessage;

    public void selectGender(String gender) {
        if (gender.equals("male")) {
            clickButton(MrRadioBtn);
        } else if (gender.equals("female")) {
            clickButton(MrsRadioBtn);
        } else {
            clickButton(MrRadioBtn);
        }
    }

    public void SendRestInfoOfPersonalInfo(String fName, String lName, String paswrd) {
        setTextElementText(customerFirstName, fName);
        setTextElementText(customerLastName, lName);
        setTextElementText(password, paswrd);
    }

    public void selectDay(String day) {
        Select Days;
        Days = new Select(days);
        Days.selectByValue(day);
    }

    public void selectMonth(String month) {
        Select Months = new Select(months);
        Months.selectByValue(month);
    }

    public void selectYear(String yaer) {
        Select Years = new Select(years);
        Years.selectByValue(yaer);
    }

    public void selectNewsLetterOption(String newsletter, String Option) {
        if (newsletter.equals("1")) {
            if (Option.equals("1")) {
                clickButton(newsLetter);
                clickButton(optin);
            } else {
                clickButton(newsLetter);
            }
        } else if (Option.equals("1")) {
            clickButton(optin);
        }

    }

    //Your address section actions
    public void getAddress(String Address, String City, String State, String Postcode, String Country) {
        setTextElementText(address, Address);
        setTextElementText(city, City);
        Select StateSelect = new Select(state);
        StateSelect.selectByVisibleText(State);
        setTextElementText(postalCode, Postcode);
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText(Country);
    }

    public void getRestPhone(String Phone, String Alias) {
        setTextElementText(mobilePhone, Phone);
        setTextElementText(alias, Alias);
    }

    //Register Button Action
    public void register() {
        clickButton(registerBtn);
    }

    public String getActualErrorMessage() {
        String actualErrorMessage = getTextElement(errorMessage);
        return actualErrorMessage;
    }

}
