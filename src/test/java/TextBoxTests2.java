import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;
public class TextBoxTests2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Dobrovolskaya");
        $("#userEmail").setValue("ally999@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8906654345");
        //календарь
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(2);
        $(".react-datepicker__year-select").selectOption(86);
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("C:\\Users\\edobrovolskaya\\IdeaProjects\\git23\\src\1.jpg");
        $("#currentAddress").setValue("Lenina54");

        $("#state").scrollIntoView(true);
        $("#stateCity-wrapper").find(byText("Select State")).click();
        $(byText("NCR")).click();
        $("#stateCity-wrapper").find(byText("Select City")).click();
        $(byText("Gurgaon")).click();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Elena Dobrovolskaya"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("ally999@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8906654345"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("27 February,1986"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Lenina54"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));
        $("#closeLargeModal").click();

            }
}
