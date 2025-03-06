package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import utils.TestDataFaker;

@Tag("demoqa")
public class PracticeFormTests extends TestBase {

    private final StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    TestDataFaker testDataFaker = new TestDataFaker();

    @Test
    public void succesfullFillAllPracticeFormTest() {
        studentRegistrationPage.openPage()
                .disableBanners()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setUserEmail(testDataFaker.email)
                .setGenderWrapper(testDataFaker.gender)
                .setUserNumber(testDataFaker.mobileNumber)
                .setDateOfBirth(testDataFaker.dayOfBirth, testDataFaker.monthOfBirth, testDataFaker.yearOfBirth)
                .setSubjects(testDataFaker.subject)
                .setHobbies(testDataFaker.hobby)
                .imageUpload(testDataFaker.picture)
                .setCurrentAddress(testDataFaker.address)
                .setUserState(testDataFaker.state)
                .setUserCity(testDataFaker.city)
                .submitButtonClick()

                .checkRegistrationResultMessage("Thanks for submitting the form")
                .checkRegistrationResultTable("Student Name",testDataFaker.firstName + " " + testDataFaker.lastName)
                .checkRegistrationResultTable("Student Email",testDataFaker.email)
                .checkRegistrationResultTable("Gender",testDataFaker.gender)
                .checkRegistrationResultTable("Mobile",testDataFaker.mobileNumber)
                .checkRegistrationResultTable("Date of Birth",testDataFaker.dayOfBirth + " " + testDataFaker.monthOfBirth + "," + testDataFaker.yearOfBirth)
                .checkRegistrationResultTable("Subjects",testDataFaker.subject)
                .checkRegistrationResultTable("Hobbies",testDataFaker.hobby)
                .checkRegistrationResultTable("Picture",testDataFaker.picture)
                .checkRegistrationResultTable("Address",testDataFaker.address)
                .checkRegistrationResultTable(testDataFaker.state,testDataFaker.city);
    }

    @Test
    public void succesfullMimimumDataPracticeFormTest() {
        studentRegistrationPage.openPage()
                .disableBanners()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setGenderWrapper(testDataFaker.gender)
                .setUserNumber(testDataFaker.mobileNumber)
                .submitButtonClick()

                .checkRegistrationResultMessage("Thanks for submitting the form")
                .checkRegistrationResultTable("Student Name",testDataFaker.firstName + " " + testDataFaker.lastName)
                .checkRegistrationResultTable("Gender",testDataFaker.gender)
                .checkRegistrationResultTable("Mobile",testDataFaker.mobileNumber);
    }

    @Test
    public void notValidPhoneNumberPracticeFormTest() {
        studentRegistrationPage.openPage()
                .disableBanners()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setGenderWrapper(testDataFaker.gender)
                .setUserNumber(testDataFaker.notValidMobileNumber)
                .submitButtonClick()

                .checkMobileNumberError();
    }

}
