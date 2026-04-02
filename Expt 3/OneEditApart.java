public class OneEditApart{
    public static void main(String args[]){
        if(args.length != 2){
            System.out.println("Please provide exactly two strings as arguments.");
            return;
        }
        String arg1 = args[0];
        String arg2 = args[1];
        compareStrings(arg1, arg2);
    }

    public static void compareStrings(String str1, String str2){
        if(str1.equals(str2)){
            System.out.println("The strings are identical.");
            return;
        }

        int len1 = str1.length();
        int len2 = str2.length();

        if(Math.abs(len1 - len2) > 1){
            System.out.println("The strings are more than one edit apart.");
            return;
        }

        if(len1 == len2){
            int diffCount = 0;
            for(int i = 0; i < len1; i++){
                if(str1.charAt(i) != str2.charAt(i)) diffCount++;
                if(diffCount > 1){
                    System.out.println("The strings are more than one edit apart.");
                    return;
                }
            }
            System.out.println("The strings are exactly one edit apart (replacement).");
        }

        else {
            String longer = len1 > len2 ? str1 : str2;
            String shorter = len1 > len2 ? str2 : str1;
            int i = 0, j = 0, edits = 0;
            while(i < longer.length() && j < shorter.length()){
                if(longer.charAt(i) != shorter.charAt(j)){
                    edits++; i++;
                    if(edits > 1) {
                        System.out.println("The strings are more than one edit apart.");
                        return;
                    }
                }
                else {
                    i++; j++;
                }
            }
            System.out.println("The strings are exactly one edit apart (insertion/deletion).");
        }
    }
}
