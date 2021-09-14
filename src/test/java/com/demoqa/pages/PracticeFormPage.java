package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final String NAME_TITLE = "Student Registration Form";
    private final String NAME_TITLE_RESULT = "Thanks for submitting the form";
    private SelenideElement
            formTitleLocator = $(".practice-form-wrapper"),
            formTitleResultsLocator = $(".modal-title"),
            firstNameLocator = $("#firstName"),
            lastNameLocator = $("#lastName"),
            emailLocator = $("#userEmail"),
            userGenderLocator = $("#genterWrapper"),
            userMobilePhoneLocator = $("input#userNumber"),
            userSubjectsLocator = $("#subjectsInput"),
            userHobbiesLocator = $("#hobbiesWrapper"),
            tableValueLocator = $(".table-responsive"),
            submitButtonLocator = $("#submit"),
            carrentAdressLocator = $("#currentAddress"),
            userPictureLocator = $("#uploadPicture");

    public SelenideElement
            selectStateLocator = $("#state"),
            selectCityLocator = $("#city"),
            selectSubject = $("#subjectsContainer");

    public CalendarComponent calendar = new CalendarComponent();                // import calendars components

    public PracticeFormPage openPage() {
        open("/automation-practice-form");                      // open the page
        formTitleLocator.shouldHave(text(NAME_TITLE));                          // Check title the page

        return this;                                                            // add return value RegistrationPage. Allow us make chains
    }

    public PracticeFormPage checkTitleResults() {
        formTitleResultsLocator.shouldHave(text(NAME_TITLE_RESULT));

        return this;
    }

    public PracticeFormPage typeFirstName(String value) {
        firstNameLocator.setValue(value);                                       // enter first name

        return this;
    }

    public PracticeFormPage typeLastName(String value) {
        lastNameLocator.setValue(value);                                        // enter last name

        return this;
    }

    public PracticeFormPage typeEmail(String value) {                           // enter email
        emailLocator.setValue(value);

        return this;
    }

    public PracticeFormPage selectGender(String value) {                        // enter email
        userGenderLocator.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage typeMobilePhone(String number) {                    // enter email
        userMobilePhoneLocator.setValue(number);

        return this;
    }

    public PracticeFormPage selectSubjects(String value) {                      // select  Subjects
        userSubjectsLocator.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage selectHobbies(String value) {                      // select  Subjects
        userHobbiesLocator.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage checkResultValue(String key, String value) {
        tableValueLocator.$(byText(key)).parent().shouldHave(text(value));      // checking the fields filled with data

        return this;
    }

    public PracticeFormPage selectState(String value) {
        selectStateLocator.$(byText(value)).click();                            // select State

        return this;
    }

    public PracticeFormPage selectCity(String value) {
        selectCityLocator.$(byText(value)).click();                             // select City

        return this;
    }

    public PracticeFormPage typeCurrentAddress(String value) {                  // enter Current Address
        carrentAdressLocator.setValue(value);

        return this;
    }

    public void submitData() {
        submitButtonLocator.pressEnter();                                       // enter Current Address
    }

    public void typeCurrentAdress(String address) {
        carrentAdressLocator.setValue(address);                                 // enter Current Address
    }

    public void uploadPicture(String picturePath) {
        File file = new File(picturePath);
        userPictureLocator.scrollIntoView(true).uploadFile(file);               // upload user Picture
    }


}
