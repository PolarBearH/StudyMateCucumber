package steps;

import Pages.StudentsPageStudyMate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class StudentsSteps {

    StudentsPageStudyMate studentsPageStudyMate = new StudentsPageStudyMate();


    // Add a Student

    // Click the add student button
    @When("clicks the add student button")
    public void clicks_the_button() throws InterruptedException {
        studentsPageStudyMate.clickAddStudentButton();

        // Wait for 5 seconds (consider using more specific waits based on application behavior)
        Thread.sleep(3000);
    }

    // Fill in student information and add the student
    @And("fills in student information and adds the student")
    public void fills_in_student_information() throws InterruptedException {
        studentsPageStudyMate.fillStudentInformation();
        studentsPageStudyMate.selectGroup();
        studentsPageStudyMate.selectStudyFormat();
        studentsPageStudyMate.clickAddButton();

        // Wait for 5 seconds (consider using more specific waits based on application behavior)
        Thread.sleep(Duration.ofSeconds(5));
    }

    // Verify that the number of students has increased
    @Then("the number of students should increase")
    public void the_number_of_students_should_increase() {
        Assert.assertEquals(studentsPageStudyMate.getNumberOfStudentsText(), "from 2");
    }


    // Delete a student

    // Click the three dots button under actions next to a student and confirm deletion
    @When("clicks the three dots button under actions next to a student and confirms deletion")
    public void clicks_the_three_dots_button_under_actions_next_to_a_student_and_confirms_deletion() throws InterruptedException {
        studentsPageStudyMate.deleteStudent();

        // Wait for 5 seconds (consider using more specific waits based on application behavior)
        Thread.sleep(3000);
    }

    // Verify that the number of students has decreased
    @Then("the number of students should decrease")
    public void the_number_of_students_should_decrease() {
        // Verify that the number of students is now "from 1"
        studentsPageStudyMate.waitForNumberOfStudentsAfterDeletion("from 1");
        assertEquals("from 1", studentsPageStudyMate.getNumberOfStudentsText());
    }
}
