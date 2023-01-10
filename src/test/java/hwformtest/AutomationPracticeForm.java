package hwformtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void automationPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        //Заполнить форму
        $("#firstName").setValue("Bob"); //имя
        $("#lastName").setValue("White"); //фамилия
        $("[for=gender-radio-1]").click(); //гендер
        $("#userEmail").setValue("test@ya.ru"); //email
        $("#userNumber").setValue("89004840000"); //телефон

        $("#dateOfBirthInput").click(); //дата рождения
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__day").findBy(text("10")).click();

        $("#subjectsInput").setValue("Physics").pressEnter(); //предмет
        $("[for=hobbies-checkbox-3]").click(); //хобби
        $("#uploadPicture").uploadFromClasspath("33.jpg"); //фото
        $("#currentAddress").setValue("Swamp Street, 1"); //адрес

        $(byText("Select State")).click(); //штат
        $(byText("NCR")).click();

        $(byText("Select City")).click(); //город
        $(byText("Noida")).click();

        //Нажать кнопку "Submit"
        $("[id=submit]").click();

        // Отображение окна с текстом "Thanks for submitting the form" и заполненными данными
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").
                shouldHave(text("Bob White"),
                        text("test@ya.ru"),
                        text("Male"),
                        text("8900484000"),
                        text("10 April,2000"),
                        text("Physics"),
                        text("Music"),
                        text("Swamp Street, 1"),
                        text("NCR Noida"));
    }
}
