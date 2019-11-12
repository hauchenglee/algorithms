package stackqueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import stackqueue.list.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.print(stack.pop());
            else stack.push(s);
        }
    }
}