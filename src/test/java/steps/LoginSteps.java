package steps;

import Pages.LoginPageStudyMate;
import Pages.StudentsPageStudyMate;
import io.cucumber.java.BeforeAll;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

import static utilities.Driver.driver;

public class LoginSteps {

    @BeforeAll
    public static void beforeAllScenarios() {
        // Background to get to the student tab

        // Get the WebDriver instance
        driver = Driver.getDriver();

        // Open the login page
        driver.get("https://codewiser.studymate.us/login");

        // Instantiate the LoginPageStudyMate class
        LoginPageStudyMate loginPageStudyMate = new LoginPageStudyMate();

        // Perform login
        loginPageStudyMate.loginIn();

        // Instantiate the StudentsPageStudyMate class
        StudentsPageStudyMate studentsPageStudyMate = new StudentsPageStudyMate();

        // Set up WebDriverWait for 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the URL contains "analytics"
        wait.until(ExpectedConditions.urlContains("analytics"));

        // Verify that the current URL is the correct URL
        String correctUrl = "https://codewiser.studymate.us/admin/analytics";
        Assert.assertEquals(driver.getCurrentUrl(), correctUrl);

        // Additional wait for the Students tab to load, adjust as needed
        wait.until(ExpectedConditions.visibilityOf(studentsPageStudyMate.studentsTab)).click();
    }
}
