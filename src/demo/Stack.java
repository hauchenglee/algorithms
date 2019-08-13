package demo;

public class Stack {
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
    }

    private String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}
