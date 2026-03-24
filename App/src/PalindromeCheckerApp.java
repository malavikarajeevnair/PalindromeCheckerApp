/**
 * A utility class designed for Palindrome validation.
 * Demonstrates Encapsulation and Single Responsibility.
 */
class PalindromeChecker {

    // Internal Data Structure Preference (could be changed without affecting the user)
    private String cleanString;

    /**
     * Public method to expose functionality.
     * @param input The raw string to check.
     * @return true if palindrome, false otherwise.
     */
    public boolean isValid(String input) {
        if (input == null) return false;

        this.cleanString = preprocess(input);
        return performCheck();
    }

    // Private helper method (Encapsulation: User doesn't need to see this)
    private String preprocess(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // The actual algorithm (currently using Two-Pointer for efficiency)
    private boolean performCheck() {
        int left = 0;
        int right = cleanString.length() - 1;

        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Driver Class
public class Main {
    public static void main(String[] args) {
        // Create an instance of the checker
        PalindromeChecker checker = new PalindromeChecker();

        String test = "Was it a car or a cat I saw?";

        if (checker.isValid(test)) {
            System.out.println("The phrase is a valid palindrome.");
        }
    }
}