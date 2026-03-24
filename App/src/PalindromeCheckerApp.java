public class NormalizedPalindrome {
    public static void main(String[] args) {
        String input = "No 'x' in Nixon";

        if (isPalindrome(input)) {
            System.out.println("It's a normalized palindrome!");
        } else {
            System.out.println("It's not a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        // 1. Normalize: Remove anything that isn't a letter or number
        // [^a-zA-Z0-9] means "match anything NOT in these ranges"
        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 2. Apply logic (Two-Pointer used here for efficiency)
        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}