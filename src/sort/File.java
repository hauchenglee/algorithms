package sort;

public class File implements Comparable<File> {
    @Override
    public int compareTo(File o) {
        return 0;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
//                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
