package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.tests.TestData.*;

public class PracticeFormTests extends TestBase{

    RegistrationPage registrationPages = new RegistrationPage();

    @Test
    void formTests() {
        String path = "src/test/resources/img/testPicture.jpg";
        File file = new File(path);

        //Step 1: Open page and check title
        registrationPages.openPage();
        // Step 2 : Enter values in fields First Name, Last Name, Email
        registrationPages.typeFirstName(firstName);
        registrationPages.typeLastName(lastName);
        registrationPages.typeEmail(userEmail);

        // GenderRadioButton Test
        $("#genterWrapper").$(byText("Male")).click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#genterWrapper").$(byText("Other")).click();

        // mobilePhone Test
        $("input#userNumber").setValue(userNumber);

        // dateOfBirth Test
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__month .react-datepicker__week .react-datepicker__day--013").click();

        // subjectsField Test
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();

        // HobbiesCheckBoxes Test
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        // Scrolling the page
        $("#uploadPicture").scrollIntoView(true);
        //$("#uploadPicture").scrollIntoView(true).uploadFile(file);

        // selectPicture Test
        $("#uploadPicture").scrollIntoView(true).uploadFile(file);
        //$("#uploadPicture").uploadFromClasspath("././img/testPicture.jpg");

        // CurrentAddress Test
        $("#currentAddress").setValue(currentAddress);

        // selectStateAndselectCity Test
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();

        // submitting Test
        $("#submit").pressEnter();

        //Checking filled fields
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("13 July,2000"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Hindi, Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("testPicture.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));

    }

    @Test
    void checkRequiredFieldsTest() {
        open("/automation-practice-form");

        // checking the title name
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        // checking Required Fields
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $("#firstName").scrollIntoView(true);
        $(".was-validated").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[name=gender][value=Other]").parent().shouldHave(cssValue("color", "rgb(33, 37, 41)"));
        $("[name=gender][value=Male]").parent().shouldHave(cssValue("color", "rgb(33, 37, 41)"));
        $("[name=gender][value=Female]").parent().shouldHave(cssValue("color", "rgb(33, 37, 41)"));
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }


}
