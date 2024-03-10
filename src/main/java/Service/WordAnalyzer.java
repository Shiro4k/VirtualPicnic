package Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordAnalyzer {
    public void analyze(String text) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int wordCount = 0;
            String longestWord = "";
            Map<String, Integer> wordFrequency = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");

                // Подсчет слов
                wordCount++;

                // Поиск самого длинного слова
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }

                // Подсчет частоты слов
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            System.out.println("Количество слов в файле: " + wordCount);
            System.out.println("Самое длинное слово: " + longestWord);
            System.out.println("Частота слов:");

            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }
    }

}
