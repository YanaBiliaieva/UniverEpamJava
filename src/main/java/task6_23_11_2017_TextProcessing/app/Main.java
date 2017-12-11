package task6_23_11_2017_TextProcessing.app;

import task6_23_11_2017_TextProcessing.entities.Word;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yana Biliaieva
 * Task: Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др.
 * Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
 * 7.	Рассортировать слова текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове).
 */
public class Main {
    private static String fileName="src/main/java/resource/text.txt";
    public static void main(String[] args) throws IOException {
        //берем текст
        String content = readFile(fileName, StandardCharsets.UTF_8);
        System.out.println(content);
        String[] words = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");//\\s+ - matches sequence of one or more whitespace characters.
        System.out.println(Arrays.toString(words));
        //считаем долю гласных букв в словах
        Word[] wordArray = new Word[words.length];
        wordArray=vowelCount(words);
        //сортируем слова в тексте
        Word[] sortedWords = sortWordsByVowelShare(wordArray);
        //выводим
        System.out.println(Arrays.toString(sortedWords));
    }
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    public static Word[] sortWordsByVowelShare(Word[] words){
        Word[] sortedWords=words;
        Arrays.sort(words, new Comparator<Word>() {
            public int compare(Word word1, Word word2) {
                return word1.getVowelLettersShare() - word2.getVowelLettersShare();
            }
        });
        return sortedWords;
    }
    public static Word[] vowelCount(String[] words){
        Word[] wordArray = new Word[words.length];
        for (int i = 0; i < words.length; i++) {
            String line = words[i];
            String pattern = "[aeiou]";
            float vowelCount = line.length() - (line.replaceAll(pattern, "").length());//присваиваем слову число
            int vowelCountShare = 0;
            if (vowelCount > 0) {
                vowelCountShare=(int)((vowelCount/line.length())*100f);
            }
            Word word = new Word(vowelCountShare, line);
            wordArray[i] = word;
        }return wordArray;
    }
}
