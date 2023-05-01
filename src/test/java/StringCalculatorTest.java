import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void BeforeEach(){
        calculator = new StringCalculatorImpl();
    }

    @Test
    public void TestEmptyStringReturnsZero(){
        Assertions.assertEquals(0, calculator.Add(""));
    }
}
