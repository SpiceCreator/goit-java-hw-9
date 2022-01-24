package file.read.users.info;

import file.read.utils.FileToStringConverter;
import file.read.utils.StringToFileWriter;
import file.read.utils.StringToJSONConverter;

import java.io.File;

public class StringToJSONTester {
    public static void main(String[] args) {
        String usersInfo = FileToStringConverter.convert("src/main/Users.txt");
        String json = StringToJSONConverter.convert(usersInfo);
        StringToFileWriter.write(json, "src/main/user.json");
    }
}
