package co.com.study.exercise;

public class Palindrome {
    static boolean isAlmostPalindrome(String palabra)
    {
        int i = 0, j = palabra.length() - 1;
        int badLetterCounter = 0;
        while (i < j) {
            if (palabra.charAt(i) != palabra.charAt(j)) badLetterCounter++;
            i++;
            j--;
        }
        return badLetterCounter <=1;
    }

    public static void main(String ... args){
        System.out.println(isAlmostPalindrome("ana"));
        System.out.println(isAlmostPalindrome("abccba"));
        System.out.println(isAlmostPalindrome("abccbe"));
        System.out.println(isAlmostPalindrome("abccfg"));

    }
}


