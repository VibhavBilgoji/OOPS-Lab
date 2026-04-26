import java.util.Scanner;

class StringOperations {
    private char[] chars;
    private String original;

    public StringOperations(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        this.original = str;
        this.chars = str.toCharArray();
    }

    public int countVowels() {
        int count = 0;
        String lower = original.toLowerCase();
        for (char c : lower.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count;
    }

    public int countVowels(boolean includeY) {
        int count = countVowels();
        if (includeY) {
            String lower = original.toLowerCase();
            for (char c : lower.toCharArray()) {
                if (c == 'y') count++;
            }
        }
        return count;
    }

    public String reverse() {
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public boolean isPalindrome() {
        return original.equalsIgnoreCase(reverse());
    }

    public void printFrequencies() {
        int[] freq = new int[256];
        for (char c : chars) {
            freq[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + ": " + freq[i]);
            }
        }
    }
}

public class OpsOnString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            StringOperations ops = new StringOperations(input);

            System.out.println("Vowels: " + ops.countVowels());
            System.out.println("Vowels (including y): " + ops.countVowels(true));
            System.out.println("Reversed: " + ops.reverse());
            System.out.println("Is Palindrome: " + ops.isPalindrome());
            System.out.println("Frequencies:");
            ops.printFrequencies();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred.");
        } finally {
            scanner.close();
        }
    }
}