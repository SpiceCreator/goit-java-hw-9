package file.read.phone.numbers;

import file.read.utils.CorrectPhoneNumberDetector;
import file.read.utils.FileToStringConverter;

import java.io.File;


public class PhoneNumberReaderTest {
    public static void main(String[] args) {
        String allNumbers = FileToStringConverter.convert("src/main/PhoneNumbers.txt");
        CorrectPhoneNumberDetector.detect(allNumbers);
    }
}
