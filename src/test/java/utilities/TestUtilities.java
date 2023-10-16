package utilities; // Define the package name

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class TestUtilities { // Create a class named TestUtilities for utility functions
    // Function to generate a random string of a given length
    private static final Faker faker = new Faker();

    public static String generateRandomString() {
        return faker.name().username();
    }

    public static String generateRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    // Function to clear the input field
    public static void clearInputField(WebDriver driver, By locator) {
        WebElement inputField = driver.findElement(locator); // Find the input field element
        inputField.click(); // Click on the input field
        Actions actions = new Actions(driver); // Create an Actions object
        actions.keyDown(Keys.COMMAND) // Press the COMMAND key (for Mac)
                .sendKeys("a") // Send "a" to select all text
                .keyUp(Keys.COMMAND) // Release the COMMAND key
                .build() // Build the action sequence
                .perform(); // Perform the action
        inputField.sendKeys(Keys.DELETE); // Delete the selected text
    }
}
