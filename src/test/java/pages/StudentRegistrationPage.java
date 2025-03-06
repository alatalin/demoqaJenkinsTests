package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            imageUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            registrationResultMessage = $("#example-modal-sizes-title-lg");

    public CalendarComponent calendarComponent = new CalendarComponent();
    public TableComponent tableComponent = new TableComponent();

    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public StudentRegistrationPage disableBanners (){
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public StudentRegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setGenderWrapper(String value) {
        genderWrapperInput.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationPage setUserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setDateOfBirth (String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    public StudentRegistrationPage setSubjects (String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public StudentRegistrationPage setHobbies (String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationPage imageUpload (String value) {
        imageUpload.uploadFromClasspath(value);
        return this;
    }

    public StudentRegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setUserState (String value) {
        userStateInput.setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage setUserCity (String value) {
        userCityInput.setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage submitButtonClick() {
        submitButton.click();
        return this;
    }

    public StudentRegistrationPage checkRegistrationResultMessage(String value) {
        registrationResultMessage.shouldHave(text(value));
        return this;
    }

    public StudentRegistrationPage checkRegistrationResultTable(String key, String value) {
        tableComponent.checkResultTableSellValue(key, value);
        return this;
    }

    public StudentRegistrationPage checkMobileNumberError() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}
