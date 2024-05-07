import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class LoggingTest {

    @Test
    public void testStringCalculatorDoesNotLogNumbersBelow1000(){
        Logger mockLogger = mock(Logger.class);
        StringCalculator calculator = new StringCalculator(mockLogger);

        calculator.add("");
        verify(mockLogger, times(0)).log(anyInt());
    }

    @Test
    public void testStringCalculatorLogsNumbersAbove1000() {
        Logger mockLogger = mock(Logger.class);
        StringCalculator calculator = new StringCalculator(mockLogger);

        calculator.add("1001");

        // Verifierar att loggern är kallad med numret
        verify(mockLogger, times(1)).log(1001);
    }

}