package leetcode;

/**
 * error：在getMin()因first = first.next;導致refer被改變
 * 以致其後first參照的位置被改變
 * v1解法：使用list儲存數值，而不是stack，避免因first改變連動
 */
public class No155_getMinInOnce {
    static class MinStack {
        private Node first = null;

        static class Node {
            int item;
            Node next;
        }

        private boolean isEmpty() {
            return first == null;
        }

        public void push(int x) {
            Node oldFirst = first;
            first = new Node();
            first.item = x;
            first.next = oldFirst;
        }

        public void pop() {
            if (!isEmpty()) {
                first = first.next;
            }
        }

        public int top() {
            if (!isEmpty()) {
                return first.item;
            }
            throw new RuntimeException();
        }

        public int getMin() {
            if (isEmpty()) {
                throw new RuntimeException();
            }

            int min = top();
            while (first != null) {
                if (first.item < min) {
                    min = first.item;
                }
                first = first.next;
            }
            return min;
        }
    }
}
