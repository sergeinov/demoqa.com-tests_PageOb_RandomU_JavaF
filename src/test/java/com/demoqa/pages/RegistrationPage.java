package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String NAME_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    public void openPage() {
        open("/automation-practice-form");    // open the page
        formTitle.shouldHave(text(NAME_TITLE));             // Check title the page
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);                 // enter first name
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);                   // enter last name
    }

    public void typeEmail(String value) {                   // enter email
        emailInput.setValue(value);
    }


}
