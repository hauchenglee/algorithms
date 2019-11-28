package leetcode;

import java.util.Arrays;

/**
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 */

public class No961 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        // 1 2 2 2 3 5
        // n = 3
        System.out.println(repeatedNTimes_solution(arr));
    }

    public static int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int count = 1;
        int halfSize = A.length / 2;
        for (int i = 0; i < A.length; i++) {
            if (i + 1 >= A.length) {
                break;
            } else {
                if (A[i] == A[i + 1]) {
                    count++;
                    if (count == halfSize) {
                        return A[i];
                    }
                }
            }

        }
        return 0;
    }

    // solution
    public static int repeatedNTimes_solution(int[] A) {
        // int[] arr = {5,1,5,2,5,3,5,4};
        // 1,2,3,3
        int[] count = new int[100];
        for (int a : A) {
//            System.out.println("a1 : " + a);
            if (count[a]++ == 1) {
                System.out.println("a : " + a);
                System.out.println("count[a] : " + count[a]);
                System.out.println("count[a]++ : " + count[a]++);
                return a;
            }
        }
//        for (int i = 0; i < count.length; i++) {
//            System.out.println(count[2]);
//        }
        return -1;
    }
}
