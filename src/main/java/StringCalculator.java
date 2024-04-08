import java.util.Arrays;

public class StringCalculator {

    public int add(String input) throws Exception {

        if(input.isEmpty()) {
            return 0;
        }

        String[] splitInput = input.split("\n");
        String delimiter = ",";
        if (splitInput.length > 1 && splitInput[0].startsWith("//")) {
            delimiter = String.valueOf(splitInput[0].charAt(2));
            splitInput = splitInput[1].split(delimiter, 0);
        } else {
            splitInput = input.split("[" + delimiter + "\n]", 0);
        }

        int result = 0;
        for (String s : splitInput) {
            if(Integer.parseInt(s) < 0) {
                throw new NumberFormatException("No negatives allowed " + Integer.parseInt(s));
            }
            result += Integer.parseInt(s);
        }

        return result;
    }
}
