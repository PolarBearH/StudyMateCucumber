package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class LoginPageStudyMate {

    public LoginPageStudyMate() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passWordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    public WebElement loginButton;

    // Methods

    public void loginIn() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        emailField.sendKeys("admin@codewise.com");
        passWordField.sendKeys("codewise123");
        loginButton.click();


    }


}
