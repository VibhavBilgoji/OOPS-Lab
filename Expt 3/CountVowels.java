import java.util.Scanner;

public class CountVowels {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        sc.close();

        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        short vowelCount = 0,
            consonentCount = 0;
        String lowerStr = str.toLowerCase();

        for (int i = 0; i < lowerStr.length(); ++i) {
            char c = lowerStr.charAt(i);

            if (Character.isAlphabetic(c)) {
                boolean flag = false;
                for (int j = 0; j < vowels.length; ++j) {
                    if (vowels[j] == c) {
                        ++vowelCount;
                        flag = true;
                        break;
                    }
                }
                if (!flag) ++consonentCount;
            }
        }
        System.out.println("\nVowel Count: " + vowelCount);
        System.out.println("Consonent Count: " + consonentCount);
    }
}
