import java.util.Stack;

public class StackPalindrome {
    public static void main(String[] args) {
        String input = "madam";

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        // Clean the string to handle case sensitivity
        String cleanStr = str.toLowerCase();
        Stack<Character> stack = new Stack<>();

        // 1. Push: Add all characters to the stack
        for (int i = 0; i < cleanStr.length(); i++) {
            stack.push(cleanStr.charAt(i));
        }

        // 2. Pop and Compare: Compare original string with popped characters
        for (int i = 0; i < cleanStr.length(); i++) {
            char poppedChar = stack.pop();
            if (cleanStr.charAt(i) != poppedChar) {
                return false; // Mismatch found
            }
        }

        return true; // If we reach here, it's a palindrome
    }
}


