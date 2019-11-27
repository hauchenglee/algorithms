package leetcode;

import util.TimeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No155_v1 {
    static class MinStack {
        private Node first = null;
        private List<Integer> integerList = new ArrayList<>();

        static class Node {
            int item;
            Node next;
        }

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public static void main(String[] args) {
            long s = TimeUtils.start();
            MinStack obj = new MinStack();
            obj.push(2);
            obj.push(0);
            obj.push(3);
            obj.push(0);
            int a = obj.getMin();
            obj.pop();
            int b = obj.getMin();
            obj.pop();
            int c = obj.getMin();
            obj.pop();
            int d = obj.getMin();
            long e = TimeUtils.end();
            System.out.println(TimeUtils.toSeconds(s, e));
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(c);
//            System.out.println(d);
        }

        private boolean isEmpty() {
            return first == null;
        }

        public void push(int x) {
            Node oldFirst = first;
            first = new Node();
            first.item = x;
            first.next = oldFirst;

            integerList.add(x);
            Collections.sort(integerList);
        }

        public void pop() {
            if (isEmpty()) {
                throw new RuntimeException();
            }
            int popItem = first.item;
            integerList.remove((Integer) popItem);
            first = first.next;
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
            return integerList.get(0);
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
