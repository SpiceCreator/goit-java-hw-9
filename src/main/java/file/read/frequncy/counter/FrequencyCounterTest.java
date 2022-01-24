package file.read.frequncy.counter;

import file.read.utils.FileToStringConverter;
import file.read.utils.WordsFrequencyCounter;

public class FrequencyCounterTest {
    public static void main(String[] args) {
        String sourceText = FileToStringConverter.convert("src/main/words.txt");
        WordsFrequencyCounter.count(sourceText);
    }
}
