package demo;

public class Queue {
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private void push(String item) {
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else oldLast.next = last;
    }

    private String pop() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }
}
