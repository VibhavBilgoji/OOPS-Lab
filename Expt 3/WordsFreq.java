import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class WordsFreq{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();
        sc.close();
        displayWordCounts(sentence);
    }

    public static void displayWordCounts(String str){
        Map<String, Integer> map = new HashMap<>();
        String[] words = str.split("[-,_.:;/\\s\\\\]+");
        for(String w : words)
            if(!w.isEmpty()) map.merge(w.toLowerCase(), 1, Integer::sum);

        System.out.println("\nFrequency of Words:");
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
