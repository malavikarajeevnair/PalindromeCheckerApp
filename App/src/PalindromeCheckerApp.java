class Node {
    char data;
    Node next;
    Node(char d) { data = d; }
}

public class LinkedListPalindrome {
    public static void main(String[] args) {
        String input = "racecar";
        Node head = sToList(input);

        if (isPalindrome(head)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // 1. Find the middle using Fast & Slow pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // 3. Compare halves
        Node temp = secondHalf; // Keep reference to reverse back later
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static Node reverse(Node head) {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Helper to convert String to Linked List
    private static Node sToList(String s) {
        Node dummy = new Node(' ');
        Node curr = dummy;
        for (char c : s.toLowerCase().toCharArray()) {
            curr.next = new Node(c);
            curr = curr.next;
        }
        return dummy.next;
    }
}

