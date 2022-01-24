package file.read.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToJSONConverter {
    public static String convert(String initString) {

        if (initString == null) {
            return "[]";
        }

        Scanner scanner = new Scanner(initString);
        String[] columns;
        if (scanner.hasNextLine()) {
             columns = scanner.nextLine().split(" ");
        } else {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+");

        stringBuilder.append("[\n");

        while (scanner.hasNextLine()) {

            String[] values = scanner.nextLine().split(" ");
            stringBuilder.append("\t{\n");

            for (int j = 0; j < values.length; j++) {
                stringBuilder.append("\t\t\"" + columns[j] + "\":");
                Matcher matcher = pattern.matcher(values[j]);
                if (matcher.matches()) {
                    stringBuilder.append(values[j]);
                } else {
                    stringBuilder.append("\"" + values[j] + "\"");
                }
                if (j != values.length - 1) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append("\t}");
            if (scanner.hasNextLine()) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
