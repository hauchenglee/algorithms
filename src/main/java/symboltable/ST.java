package symboltable;

import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> {
    private TreeMap<Key, Value> st = new TreeMap();

    public ST() {
    }

    void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) st.remove(key);
        else st.put(key, val);
    }

    Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
//        if (isEmpty()) return null;
//        int i = rank(key);
//        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
//        else return null;
    }

    private int rank(Key key) {
        return 0;
//        int lo = 0, hi = N - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int cmp = key.compareTo(keys[mid]);
//            if (cmp < 0) hi = mid + 1;
//            else if (cmp > 0) lo = mid + 1;
//            else return mid;
//        }
//        return lo;
    }

    Key select(int k) {
        return null;
    }

    void delete(Key key) {
        put(key, null);
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return true;
    }

    int size() {
        return 0;
    }

    int size(Key lo, Key hi) {
        return 0;
    }

    Key min() {
        return null;
    }

    Key max() {
        return null;
    }

    Key floor(Key key) {
        return key;
    }

    Key ceiling(Key key) {
        return key;
    }

    Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    Iterable<Key> keys() {
        return null;
    }
}
