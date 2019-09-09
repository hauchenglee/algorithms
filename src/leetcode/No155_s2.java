package leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
 * 原理思想是，第一次push，預設為最小值
 * 如果第二次push比前一次小 -> add -> 目前：次小、最小
 * 如果第二次push比前一次大 -> add目前最小
 * 原因：加入比目前大沒有作用，因為是getMin()，以第一次的數值為基準點，比第一次大的永遠不會return該值
 */
public class No155_s2 {
    private Stack<Integer> data;
    private Stack<Integer> helper;

    public static void main(String[] args) {
        No155_s2 obj = new No155_s2();
        obj.push(-1);
        obj.push(-1);
        obj.push(3);
        obj.push(3);
        obj.push(2);
        obj.push(-3);
        obj.push(-1);
        obj.push(-1);
        obj.push(-3);
        int m0 = obj.getMin();
        obj.pop();
        obj.pop();
        obj.pop();
        int m1 = obj.getMin();
        obj.push(-3);
        int m2 = obj.getMin();
        int b = obj.top();
        obj.push(-2);
        int m3 = obj.getMin();
        System.out.println(m0);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(b);
        System.out.println(m3);
    }

    public No155_s2() {
        this.data = new Stack<>();
        this.helper = new Stack<>();
    }

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException();
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException();
    }
}
