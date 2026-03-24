public class CharArrayPalindrome {
    public static void main(String[] args) {
        String input = "Racecar";

        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        // 1. Convert to char array (Standardize to lowercase first)
        char[] charArray = str.toLowerCase().toCharArray();

        // 2. Initialize two pointers
        int start = 0;
        int end = charArray.length - 1;

        // 3. Compare start & end characters
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false; // Mismatch found, not a palindrome
            }
            start++; // Move forward
            end--;   // Move backward
        }

        return true; // All characters matched
    }
}


