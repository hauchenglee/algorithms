package stacks_and_queues;

public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0; // the size of stack and array next item position

    // create an array
    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        // return s[N--];

        // best, set origin is null
        // 对象游离loitering
        // 在栈的数组实现中有对象的引用，而我们並沒有真正的使用它
        // 所以当减少N时，在数组中仍然有我们已经出栈的对象的指针
        // 尽管我们知道我们不再使用了，但是Java系统不知道
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
