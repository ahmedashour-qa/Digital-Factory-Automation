package Utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MethodHelper {

    /**
     * Method to take screenshot when the test cases fail
     * @param driver
     * @param screenShotName
     */
    public void captureScreenshot(WebDriver driver, String screenShotName) {
        Path dest = Paths.get("./Screenshots", screenShotName + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    public String generateFakeEmail(String email) {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        return email;
    }

}
