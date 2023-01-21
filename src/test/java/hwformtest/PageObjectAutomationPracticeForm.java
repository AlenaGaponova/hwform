package hwformtest;

import org.junit.jupiter.api.Test;

public class PageObjectAutomationPracticeForm extends Base {

    @Test
    void automationPracticeForm() {

        registrationPage.openPage()
                .setFirstName("Bob")
                .setLastName("White")
                .setEmail("test@ya.ru")
                .setNumber("89004840000")
                .setAddress("Swamp Street, 1")
                .setGender("Male")
                .setSubjects("Physics")
                .setHobbies("Music")
                .setBirthDate("10", "April", "2000")
                .setPicture("33.jpg")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmitButton();

        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", "Bob White")
                .verifyResult("Student Email", "test@ya.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8900484000")
                .verifyResult("Date of Birth", "10 April,2000")
                .verifyResult("Subjects", "Physics")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "33.jpg")
                .verifyResult("Address", "Swamp Street, 1")
                .verifyResult("State and City", "NCR Noida");
    }
}
