import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        Assertions.assertEquals(0, calculator.add(""));
    }

    @Test
    public void testPopulatedStrings() {
        Assertions.assertEquals(1, calculator.add("1"));
        Assertions.assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testNewlineDelimiter() {
        Assertions.assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        Assertions.assertEquals(3, calculator.add("//;\n1;2"));
        Assertions.assertEquals(6, calculator.add("//-\n1-2-3"));
    }

    @Test
    public void testNegativeException() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            calculator.add("-1,-2");
        });

        String expectedMessage = "No negatives allowed -1";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testComplexDelimiter() {
        Assertions.assertEquals(7, calculator.add("//[***][%%%]\n1***2%%%4"));
    }
}
