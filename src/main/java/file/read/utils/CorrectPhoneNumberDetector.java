package file.read.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectPhoneNumberDetector {

    public static void detect(String allNumbers) {

        if (allNumbers == null) {
            return;
        }

        String regex1 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";
        String regex2 = "\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        try (Scanner scanner = new Scanner(allNumbers)) {
            String currentNumber;
            while (scanner.hasNextLine()) {
                currentNumber = scanner.nextLine();
                Matcher matcher1 = pattern1.matcher(currentNumber);
                Matcher matcher2 = pattern2.matcher(currentNumber);
                if (matcher1.matches() || matcher2.matches()) {
                    System.out.println(currentNumber);
                }
            }
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }
}
