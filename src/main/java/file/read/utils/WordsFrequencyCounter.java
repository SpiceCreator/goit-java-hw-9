package file.read.utils;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequencyCounter {
    public static void count(String sourceText) {
        if (sourceText == null) {
            return;
        }

        String[] words = sourceText.split("\\s+|\\n+|\\.+|,|:|;|\"|-|”|“|\\$|\\d+|—|'|\\(|\\)|\\{|}|[|]|\\?|!");

        Map<String, Integer> wordsFrequncy = new HashMap<>();

        int frequency;

        for (String word : words) {
            if (word.length() != 0) {
                if (wordsFrequncy.containsKey(word)) {
                    frequency = wordsFrequncy.get(word);
                    wordsFrequncy.put(word, ++frequency);
                } else {
                    wordsFrequncy.put(word, 1);
                }
            }
        }

        wordsFrequncy.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println); //Это я украл-_-

    }
}
