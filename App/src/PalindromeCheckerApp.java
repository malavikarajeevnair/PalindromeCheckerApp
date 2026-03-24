import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStackPalindrome {
    public static void main(String[] args) {
        String input = "Racecar";

        if (checkPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }
    }

    public static boolean checkPalindrome(String str) {
        String cleanStr = str.toLowerCase();

        // Initialize the two structures
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // 1. Fill both structures
        for (char c : cleanStr.toCharArray()) {
            queue.add(c);  // Enqueue
            stack.push(c); // Push
        }

        // 2. Compare Dequeue vs Pop
        while (!queue.isEmpty()) {
            // Queue returns the FRONT (first char)
            // Stack returns the TOP (last char)
            if (!queue.remove().equals(stack.pop())) {
                return false; // Mismatch found
            }
        }

        return true;
    }
}

