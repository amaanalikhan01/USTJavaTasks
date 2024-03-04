import java.util.Scanner;

public class WordSearch{
    public static void main(String[] args) {
        String[] predefinedWords = {"kohli", "yuvraj", "sachin", "dhoni", "devillers", "pant", "gill"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the word to search for:\n");
        int length = scanner.nextInt();
        String[] wordsOfLengthN = findWordsOfLength(predefinedWords, length);
        if (wordsOfLengthN.length==0)
        {
            System.out.println("No words found for length : "+length);
        }
        else{
        System.out.print("Words of length " + length + ":\n");
        for (String word : wordsOfLengthN) {
            System.out.println(word);
        }
        }
    }
    public static String[] findWordsOfLength(String[] words, int length) {
        int count = 0;
        for (String word : words) {
            if (word.length() == length) {
                count++;
            }
        }
        String[] wordsOfLengthN = new String[count];
        int index = 0;
        for (String word : words) {
            if (word.length() == length) {
                wordsOfLengthN[index++] = word;
            }
        }
        return wordsOfLengthN;
    }
}