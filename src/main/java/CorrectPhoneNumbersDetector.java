import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectPhoneNumbersDetector {

    public static void main(String[] args) {
        CorrectPhoneNumbersDetector.Detect(new File("src/Source"));
    }

    public static void Detect(File file) {

        String regex1 = "\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}";
        String regex2 = "\\d{3}\\-\\d{3}\\-\\d{4}";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);


        //Способ №1

//        try (Scanner scanner = new Scanner(file)) {
//            String currentNumber;
//            while (scanner.hasNextLine()) {
//                currentNumber = scanner.nextLine();
//                Matcher matcher1 = pattern1.matcher(currentNumber);
//                Matcher matcher2 = pattern2.matcher(currentNumber);
//                if (matcher1.matches() || matcher2.matches()) {
//                    System.out.println(currentNumber);
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println("ex.getMessage() = " + ex.getMessage());
//        }

        char[] symbols = new char[1024];
        try (FileReader fileReader = new FileReader(file)) {
            fileReader.read(symbols, 0, symbols.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String allNumbers = symbols.toString();

        String[] numbers = allNumbers.split("\n");

        for (String number : numbers) {
            System.out.println(number);
            Matcher matcher1 = pattern1.matcher(number);
            Matcher matcher2 = pattern2.matcher(number);
            if (matcher1.matches() || matcher2.matches()) {
                System.out.println(number);
            }
        }
    }
}
