package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TEXT_FORM = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            addressInput = $("#currentAddress"),
            genderInput = $("#genterWrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            birthDateInput = $("#dateOfBirthInput"),
            pictureInput = $("#uploadPicture"),
            stateInput = $(byText("Select State")),
            cityInput = $(byText("Select City"));

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text(TEXT_FORM));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value); //имя

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value); //фамилия

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value); //email

        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value); //телефон

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value); //адрес

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click(); //гендер

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter(); //предмет

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click(); //хобби

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click(); //дата рождения
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value); //фото

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click(); //штат
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click(); //город
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitButton () {
        $("[id=submit]").click(); //Нажать кнопку "Submit"

        return this;
    }

    public RegistrationPage verifyResultsModal() {
        registrationResultsModal.verifyModal();
        // Отображение окна с текстом "Thanks for submitting the form" и заполненными данными

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}

