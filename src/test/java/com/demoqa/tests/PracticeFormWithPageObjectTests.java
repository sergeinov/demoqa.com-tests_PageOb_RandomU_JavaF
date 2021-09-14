package com.demoqa.tests;

import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class PracticeFormWithPageObjectTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void formTests() {

        //Step 1: Open page and check title
        practiceFormPage.openPage();
        // Step 2 : Enter values in fields First Name, Last Name, Email
        practiceFormPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeEmail(userEmail);
        // Step 3: Select Gender of user
        practiceFormPage.selectGender(userGender);
        // Step 4: Enter number of mobilePhone
        practiceFormPage.typeMobilePhone(userNumber);
        // Step 5: Select date Of birth
        practiceFormPage.calendar.setDate("13", "July", "2000");
        // Step 6: Select subjects
        practiceFormPage.selectSubject.click();
        practiceFormPage.selectSubjects(userSubject);
        // Step 7: Select user Hobbies
        practiceFormPage.selectHobbies(userHobbies);
        // Step 8: Upload Picture
        practiceFormPage.uploadPicture(picturePath);
        // Step 9: Input Current Address
        practiceFormPage.typeCurrentAddress(currentAddress);
        // Step 10: Select State
        practiceFormPage.selectStateLocator.click();
        practiceFormPage.selectState(userState);
        // Step 11: Select City
        practiceFormPage.selectCityLocator.click();
        practiceFormPage.selectCity(userCity);
        // Step 12: Submit data
        practiceFormPage.submitData();
        // Step 13: Checking filled data and checking title
        practiceFormPage.checkTitleResults()
                        .checkResultValue("Student Name", firstName + " " + lastName)
                        .checkResultValue("Student Email", userEmail)
                        .checkResultValue("Gender", userGender)
                        .checkResultValue("Mobile", userNumber)
                        .checkResultValue("Date of Birth", "13 July,2000")
                        .checkResultValue("Subjects", userSubject)
                        .checkResultValue("Hobbies", userHobbies)
                        .checkResultValue("Picture", userPicture)
                        .checkResultValue("Address", currentAddress)
                        .checkResultValue("State and City", userState + " " + userCity);

    }

}
