import org.junit.Test;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class CheckServiceTest {

    @Test
    public void shouldSubmitRequest() {
        driver.get("http://localhost:9999");
    }
}