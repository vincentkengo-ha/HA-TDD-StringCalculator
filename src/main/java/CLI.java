import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CLI {

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public CLI() {
        inputStream = System.in;
        outputStream = System.out;
    }

    public CLI(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void run() {
        Scanner scanner = new Scanner(inputStream);
        PrintStream out = new PrintStream(outputStream);

        StringCalculator calculator = new StringCalculator();
        out.println("""
                    Type numbers to add together. Delimiter is ','
                    to change delimiters prefix your new delimiter with //
                    type 'exit' to quit""");
        while(true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int result = calculator.add(input);
                out.println("The result is: " + result);
            } catch (IllegalArgumentException e) {
                out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        out.println("Exiting...");
    }

}
