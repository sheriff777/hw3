
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_size_m");
        form.$(".input__top").setValue("Василий");
        form.$(".input_type_tel").setValue("+79270000000");
        form.$(".checkbox_size_m").click();
        form.$(".button_view_extra").click();
        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }
}

