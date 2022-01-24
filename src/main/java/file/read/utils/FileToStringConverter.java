package file.read.utils;

import java.io.File;
import java.io.IOException;

public class FileToStringConverter {

    public static String convert(String pathToSourceFile) {

        File file = new File(pathToSourceFile);

        try (java.io.FileReader fileReader = new java.io.FileReader(file)) {
            StringBuilder stringBuilder = new StringBuilder();
            int nextValue = -1;
            while ((nextValue = fileReader.read()) != -1) {
                stringBuilder.append((char) nextValue);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
