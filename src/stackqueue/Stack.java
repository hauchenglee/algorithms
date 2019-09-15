package stackqueue;

import java.util.Iterator;

/*
Q: What is an Iterable?
A: Has a method that returns an Iterator.

Q: What is an Iterator?
A: Has methods hasNext() and next().
 */

public class Stack<Item> implements Iterable<Item> {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.pop();
        boolean r = stack.isEmpty();
        System.out.println(r);
    }

    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /*
    first代表插入時的次序，非index
     */
    public void push(Item item) {
        // save a link to the first
        // 先把当前的node引用指向第二节点
        Node oldFirst = first;

        // create a new node for the beginning
        // 建立新的节点，并赋予value and reference
        first = new Node();

        // set the instance variables in the new node
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        // save item to return
        // 要pop的item
        Item item = first.item;

        // delete first node
        // 将第二（也就是当前的last）的引用换成first
        first = first.next;

        // return saved item
        return item;
    }

    /*
    实现iterable接口意味着什么呢？
    这个类需要有iterator()方法返回迭代器
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /*
    什么是迭代器呢？我们要用一个内部类
    这个例子中，命名为ListIterator的内部类实现iterator接口
    并且是泛型化的
    这个类主要完成的是实现这些方法hasNext()和next()
     */
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            /* not supported */
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
