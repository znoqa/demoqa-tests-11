package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class TestFormRegistration {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        //открываем страницу в браузере
        open("/automation-practice-form");
        //sleep(100000);
        //проверка, что страница открылась
        $(".main-header").shouldHave(text("Practice Form"));

        //заполняем форму
        $("#firstName").setValue("Irina");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("ivanova@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("9871234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2012");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#currentAddress").setValue("Milky Way Galaxy");
        $("#uploadPicture").uploadFromClasspath("i.jpg");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        //проверка заполненной формы
        $(".table-responsive").shouldHave(
                text("Irina"), text("Ivanova"),
                text("ivanova@gmail.com"),
                text("Female"),
                text("9871234567"),
                text("12 December,2012"),
                text("Maths"),
                text("Reading"),
                text("Milky Way Galaxy"),
                text("i.jpg"),
                text("NCR"), text("Delhi")
        );
    }
}
