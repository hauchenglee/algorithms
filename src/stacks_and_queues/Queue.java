package stacks_and_queues;

public class Queue {
    // 我们用一个有长度的list来代表队列
    // 我们需要两个指针
    // 一个指向第一个元素，另一个指向最后一个元素
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        // save a link to the last node
        Node oldLast = last;

        // create a new node for the end
        last = new Node();
        last.item = item;
        last.next = null;

        // special cases for empty queue
        if (isEmpty()) first = last;

        // link the new node to the end of the list
        else oldLast.next = last;
    }

    public String dequeue() {
        // save item to return
        String item = first.item;

        // delete first node
        first = first.next;

        // special cases for empty queue
        if (isEmpty()) last = null;

        //  return saved item
        return item;
    }
}
