import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CLITest {
    @Test
    public void testEmptyInput() {
        String input = System.lineSeparator() + "exit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        CLI calculator = new CLI(inputStream, outputStream);
        calculator.run();

        assertEquals("Type numbers to add together. Delimiter is ','\nto change delimiters prefix your new delimiter with //\ntype 'exit' to quit" + System.lineSeparator() + "The result is: 0" + System.lineSeparator() + "Exiting..." + System.lineSeparator(), outputStream.toString());
    }


}