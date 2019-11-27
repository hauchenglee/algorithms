package sort;

import edu.princeton.cs.algs4.Insertion;
import util.SortingUtils;

public class MergeSort {
    private static Comparable[] aux;
    private static final int CUTOFF = 10;

    /**
     * merge sort
     * @param a array of comparable
     * @param aux auxiliary array
     * @param lo the first part of the array to be sorted
     * @param mid the midpoint that divides the first part from the second
     * @param hi the end of the array
     */
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert SortingUtils.isSorted(a, lo, mid);
        assert SortingUtils.isSorted(a, mid + 1, hi);

        // copy everything over to the auxiliary array
        for (int k = lo; k <= hi; k++) aux[k] = a[k];

        int i = lo, j = mid + 1;

        // accomplishes the merge
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (SortingUtils.less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

        assert SortingUtils.isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi);
            return;
        }

        // checks that we have sth to do first
        if (hi <= lo) return;

        // then it computes the value of the midpoint same way as we did
        // for a binary search
        int mid = lo + (hi - lo) / 2;

        // sort the first half
        sort(a, aux, lo, mid);

        // sort the second half
        sort(a, aux, mid + 1, hi);

        // Stop if already sorted.
        // -> Is biggest item if first half <= smallest item in second half?
        // -> Helps for partially-ordered arrays.
        if (!SortingUtils.less(a[mid + 1], a[mid])) return;

        // and then merge them together
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void mergeBU(Comparable[] a, int lo, int mid, int hi) {

    }

    public static void sortBU(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                mergeBU(a, lo, lo + sz - 1, Math.min(lo + sz + sz -1, N - 1));
            }
        }
    }
}
