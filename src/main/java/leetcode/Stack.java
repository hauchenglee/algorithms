package leetcode;

public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
    }

    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        System.out.println();
        System.out.println();
    }

    private String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}
