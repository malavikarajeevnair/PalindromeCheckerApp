import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

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
        for (char c : clean.toCharArray()) stack.push(c);
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
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 5. PERFORMANCE BENCHMARK CLASS
class PerformanceTester {
    public void runBenchmark(String text, List<PalindromeStrategy> strategies) {
        System.out.println("--- Palindrome Performance Results (Nanoseconds) ---");
        System.out.printf("%-20s | %-15s | %-10s%n", "Strategy", "Execution Time", "Result");
        System.out.println("---------------------------------------------------------");

        for (PalindromeStrategy strategy : strategies) {
            // Start Timer
            long startTime = System.nanoTime();

            boolean result = strategy.check(text);

            // End Timer
            long endTime = System.nanoTime();
            long duration = endTime - startTime;