import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== UC5: Stack-Based Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Convert to lowercase for case-insensitive comparison
        String processed = input.toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < processed.length(); i++) {
            stack.push(processed.charAt(i));
        }

        // Pop characters and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Check palindrome
        if (processed.equals(reversed)) {
            System.out.println("Result: The given string is a PALINDROME");
        } else {
            System.out.println("Result: The given string is NOT a palindrome");
        }

        sc.close();
    }
}
public static String reverseString(String str) {
    if (str == null) return null;
    return new StringBuilder(str).reverse().toString();
}

void main() {
}


