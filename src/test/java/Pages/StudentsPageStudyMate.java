package Pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

import static utilities.Driver.driver;

public class StudentsPageStudyMate{

    Faker faker = new Faker();

    // Constructor to initialize PageFactory
    public StudentsPageStudyMate() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // URL for the Student Page
    public String url = "https://codewiser.studymate.us/admin/students";

    // Web elements annotated with @FindBy for PageFactory
    @FindBy(xpath = "//a[@href=\"/admin/students\"]")
    public WebElement studentsTab;

    @FindBy(xpath = "(//*[@class=\"css-7zvtr8\"])[3]")
    public WebElement numberOfStudentsElement;

    @FindBy(xpath = "//*[contains(text(),'Add st')]")
    public WebElement addStudentButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameField;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "(//div[@class = 'MuiSelect-select MuiSelect-outlined " +
            "MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[1]")
    public WebElement groupDropdown;

    @FindBy(xpath = "//li[@data-value='5']")
    public WebElement groupOption;

    @FindBy(xpath = "(//div[@class = 'MuiSelect-select MuiSelect-outlined " +
            "MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[2]")
    public WebElement studyFormatDropdown;

    @FindBy(xpath = "//li[@data-value='ONLINE']")
    public WebElement onlineOption;

    @FindBy(xpath = "(//button[contains(text(),'Add')])[2]")
    public WebElement addButton;

    @FindBy(xpath = "(//button[@class = \"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk\"])[4]")
    public static WebElement threeDotOption;

    @FindBy(xpath = "(//li[@class = \"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-l5jx0u\"])[6]")
    public static WebElement deleteOption;

    @FindBy(xpath = "(//*[contains(text(),'Delete')])[4]")
    public static WebElement confirmDeleteButton;

    // Methods for interacting with the page elements

    // Method to navigate to the Students tab
    public void navigateToStudentsTab() {
        studentsTab.click();
    }

    // Method to get the text of the number of students
    public String getNumberOfStudentsText() {
        return numberOfStudentsElement.getText();
    }

    // Method to click the "Add Student" button
    public void clickAddStudentButton() {
        addStudentButton.click();
    }

    // Method to fill in student information
    public void fillStudentInformation() {
        nameField.sendKeys(faker.name().firstName());
        lastNameField.sendKeys(faker.name().lastName());
        phoneNumberField.sendKeys(faker.phoneNumber().cellPhone().replaceAll("-", ""));
        emailField.sendKeys(faker.name().username() + "@gmail.com");
    }

    // Method to select a group from the dropdown
    public void selectGroup() {
        groupDropdown.click();
        groupOption.click();
    }

    // Method to select a study format from the dropdown
    public void selectStudyFormat() {
        studyFormatDropdown.click();
        onlineOption.click();
    }

    // Method to click the "Add" button
    public void clickAddButton() {
        addButton.click();
    }

    // Method to wait for the number of students to be as expected
//    public void waitForNumberOfStudents(String expectedText) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        WebElement numberOfStudents = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class=\"css-7zvtr8\"])[3]")));
//        wait.until(ExpectedConditions.textToBePresentInElement(numberOfStudents, expectedText));
//    }


    public void deleteStudent() {
        threeDotOption.click();
        deleteOption.click();
        confirmDeleteButton.click();
    }

    // Method to wait for the number of students after deletion to be as expected
    public void waitForNumberOfStudentsAfterDeletion(String expectedText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement numberOfStudents = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class=\"css-7zvtr8\"])[3]")));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfStudents, expectedText));
    }

    public void assertStudentTabUrl() {
        String expectedUrl = "https://codewiser.studymate.us/admin/students";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }



}

