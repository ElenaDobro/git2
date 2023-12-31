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
        //$("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("Lenina54");

        //$("#state").scrollIntoView(true);
        $("#stateCity-wrapper").find(byText("Select State")).click();
        $(byText("NCR")).click();
        $("#stateCity-wrapper").find(byText("Select City")).click();
        $(byText("Gurgaon")).click();
        $("#submit").click();

        //$(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("FirstNameValue LastNameValue"));





        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
