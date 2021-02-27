package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement button) {
        button.click();
    }

    public void setTextElementText(WebElement textElement, String value) {
        textElement.sendKeys(value);
    }

    public String getTextElement(WebElement textElement) {
        String text = textElement.getText();
        return text;
    }

}
