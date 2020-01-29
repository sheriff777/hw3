import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackData.csv", numLinesToSkip = 1)
    void shouldCalculateCashback(int amount, int expected, String message) {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(amount);
        assertEquals(expected, actual, message);
    }


    @Test
    void shouldGiveMassageIfAmountLessThanZero(){
        CashbackHackService service = new CashbackHackService();
        int amount = -10;
        assertThrows(IllegalArgumentException.class, ()-> service.remain(amount) );
    }

}