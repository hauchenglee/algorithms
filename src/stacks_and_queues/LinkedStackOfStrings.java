package stacks_and_queues;

public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String item; // 節點的value
        Node next; // 指向另一個節點的引用
    }

    public boolean isEmpty() {
        return first == null;
    }

    // save
    public void push(String item) {
        Node oldfirst = first;
        first = new Node(); // create new node object
        first.item = item;
        first.next = oldfirst;
    }

    // delete
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty2() {
        return first == null;
    }

    public void push2(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = first;
    }

    public String pop2() {
        String item = first.item;
        // first = null;
        first = first.next;
        first.item = null;
        return item;
    }
}
