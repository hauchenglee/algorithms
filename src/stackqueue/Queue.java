package stackqueue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    // 我们用一个有长度的list来代表队列
    // 我们需要两个指针
    // 一个指向第一个元素，另一个指向最后一个元素
    private Node first, last;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
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

    public Item dequeue() {
        // save item to return
        Item item = first.item;

        // delete first node
        first = first.next;

        // special cases for empty queue
        if (isEmpty()) last = null;

        //  return saved item
        return item;
    }
}
