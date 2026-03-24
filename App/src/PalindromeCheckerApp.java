import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// 1. STRATEGY INTERFACE
interface PalindromeStrategy {
    boolean check(String input);
}

// 2. CONCRETE STRATEGY: Character Array (Two-Pointer)
class CharArrayStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] array = clean.toCharArray();
        int start = 0, end = array.length - 1;

        while (start < end) {
            if (array[start++] != array[end--]) return false;
        }
        return true;
    }
}

// 3. CONCRETE STRATEGY: Stack (LIFO)
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();

        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// 4. CONCRETE STRATEGY: Deque (Double-Ended)
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 5. THE CONTEXT CLASS (Validator)
class PalindromeValidator {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void validate(String text) {
        if (strategy == null) {
            System.out.println("Error: Strategy not set.");
            return;
        }
        boolean result = strategy.check(text);
        System.out.println("[" + strategy.getClass().getSimpleName() + "] Result: " + result);
    }
}

// 6. MAIN DRIVER
public class PalindromeSystem {
    public static void main(String[] args) {
        PalindromeValidator validator = new PalindromeValidator();
        String testPhrase = "A man, a plan, a canal: Panama";

        System.out.println("Testing phrase: " + testPhrase + "\n");

        // Test Algorithm 1: Array
        validator.setStrategy(new CharArrayStrategy());
        validator.validate(testPhrase);

        // Test Algorithm 2: Stack
        validator.setStrategy(new StackStrategy());
        validator.validate(testPhrase);

        // Test Algorithm 3: Deque
        validator.setStrategy(new DequeStrategy());
        validator.validate(testPhrase);
    }
}