package stacks_and_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StacksOfStrings {
    public StacksOfStrings() {
    }

    void push(String item) {

    }

    String pop() {
        return "";
    }

    boolean isEmpty() {
        return this == null;
    }

    public static void main(String[] args) {
        StacksOfStrings stack = new StacksOfStrings();
        String txt = "to be or not to - be - - that - - - is";
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.print(stack.pop());
            else stack.push(s);
        }
    }
}
