import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    private final Logger logger;

    public StringCalculator() {
        this.logger = new NumberLogger();
    }

    public StringCalculator(Logger logger){
        this.logger = logger;
    }

    public int add(String input) {

        if(input.isEmpty()) {
            return 0;
        }

        String[] splitInput = input.split("\n");
        String[] numbers = new String[]{};
        String delimiter = ",";
        if(splitInput.length > 1 && splitInput[0].startsWith("//")) {
            if(String.valueOf(splitInput[0].charAt(2)).equals("[")) {
                List<String> delimiters = new ArrayList<>();
                boolean insideBracket = true;
                int start = 3;
                int i = 0;
                while(insideBracket) {
                    i++;
                    if(start+i+1 < splitInput[0].length() && String.valueOf(splitInput[0].charAt(start+i+1)).equals("[")) {
                        delimiters.add(splitInput[0].substring(start, start+i));
                        start += i + 2;
                        i = 0;
                    } else if(String.valueOf(splitInput[0].charAt(start+i)).equals("]")) {
                        delimiters.add(splitInput[0].substring(start, start+i));
                        insideBracket = false;
                    }

                    System.out.println(i);
                }
                for(String d : delimiters){
                    splitInput[1] = splitInput[1].replace(d, ",");
                }
                numbers = splitInput[1].split(",", 0);
            } else {
                delimiter = String.valueOf(splitInput[0].charAt(2));
                numbers = splitInput[1].split(delimiter, 0);
            }
        } else {
            numbers = input.split("[" + delimiter + "\n]", 0);
        }

        int result = 0;
        for (String s : numbers) {
            if(Integer.parseInt(s) < 0) {
                throw new NumberFormatException("No negatives allowed " + Integer.parseInt(s));
            }
            result += Integer.parseInt(s);
        }
        if(result > 1000) {
            logger.log(result);
        }

        return result;
    }
}
