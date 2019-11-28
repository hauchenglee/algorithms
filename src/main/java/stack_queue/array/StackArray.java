package stack_queue.array;

import java.util.Iterator;

public class StackArray<Item> implements Iterable<Item> {
    private Item[] s;

    // N既是栈的大小，又是下一个元素位置的索引
    // 栈中下一个开放的位置
    private int N = 0;

    public StackArray() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public Item pop() {
        // this version avoids "loitering"
        // garbage collector can reclaim memory
        // only if no outstanding references
        Item item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            /* not supported */
        }

        @Override
        public Item next() {
            return s[--i];
        }
    }
}
