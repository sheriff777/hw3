
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {

    @Test
    void shouldTestYes() {
        open("http://localhost:9999");
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Сыдыгалиев Айбек");
        form.$("[data-test-id=phone] input").setValue("+78745002587");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=button]").click();
        $("[data-test-id=order-success]")
                .shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.")
                );
    }

    @Test
    public void shouldTestNo() {
        open("http://localhost:9999");
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Sydygaliev Aibek");
        form.$("[data-test-id=phone] input").setValue("+78745002587");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=button]").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave
                (exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
}

