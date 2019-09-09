package leetcode;

import java.util.HashMap;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */

public class No20 {
    public static void main(String[] args) {
        No20 obj = new No20();

    }

    private HashMap<Character, Character> mappings;

    public No20() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
        this.mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mappings.containsKey(c)) {
                // pop
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // push
                if (this.mappings.containsValue(c)) {
                    stack.push(c);
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static class Stack<T> {
        private Node first = null;

        private class Node {
            T item;
            Node next;
        }

        private boolean isEmpty() {
            return first == null;
        }

        private void push(T item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
        }

        private T pop() {
            T item = first.item;
            first = first.next;
            return item;
        }
    }


//    // Hash table that takes care of the mappings.
//    private HashMap<Character, Character> mappings;
//
//    // Initialize hash map with mappings. This simply makes the code easier to read.
//    public Solution() {
//        this.mappings = new HashMap<Character, Character>();
//        this.mappings.put(')', '(');
//        this.mappings.put('}', '{');
//        this.mappings.put(']', '[');
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String s = "(({{[]}}))";
//        boolean b = solution.isValid(s);
//        System.out.println(b);
//    }
//
//    public boolean isValid(String s) {
//
//        // Initialize a stack to be used in the algorithm.
//        Stack<Character> stack = new Stack<Character>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            // If the current character is a closing bracket.
//            if (this.mappings.containsKey(c)) {
//
//                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
//                char topElement = stack.empty() ? '#' : stack.pop();
//
//                // If the mapping for this bracket doesn't match the stack's top element, return false.
//                if (topElement != this.mappings.get(c)) {
//                    return false;
//                }
//            } else {
//                // If it was an opening bracket, push to the stack.
//                stack.push(c);
//            }
//        }
//
//        // If the stack still contains elements, then it is an invalid expression.
//        return stack.isEmpty();
//    }
}
