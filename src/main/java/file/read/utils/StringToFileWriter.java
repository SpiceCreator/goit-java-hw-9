package file.read.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StringToFileWriter {
    public static boolean write(String inputString, String pathToTargetFile) {

        if (inputString == null || pathToTargetFile == null) {
            return false;
        }

        File file = new File(pathToTargetFile);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(inputString);
            fileWriter.flush();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
