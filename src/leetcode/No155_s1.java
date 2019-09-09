package leetcode;

import java.util.Stack;

public class No155_s1 {
    private Stack<Integer> stack = null;

    public No155_s1() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        No155_s1 obj = new No155_s1();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        int a = obj.getMin();
        int b = obj.top();
        obj.pop();
        int c = obj.getMin();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = (int) stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
