package leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Could you solve it without converting the integer to a string?
 */

public class No9 {
    public static void main(String[] args) {
        int x = 1221;
        System.out.println(isPalindrome_solution(x));
    }

    // 70 ms	38.8 MB
    public static boolean isPalindrome_solution(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            // rev = 0 * 10 + 121 % 10 = 1
            // rev = 1 * 10 + 12 % 10 = 12

            x = x / 10;
            // x = 121 / 10 = 12
            // x = 12 / 10 = 1

            System.out.println("x: " + x);
            System.out.println("rev: " + rev);
        }

        // 當數字為偶數  || 當數字為奇數
        return (x == rev || x == rev / 10);
    }

    // 101 ms	42.5 MB
    public static boolean isPalindrome_string(int x) {
        String[] arr = Integer.toString(x).split("");
        for (int i = 0; i < arr.length / 2; i++) {
            if (!arr[i].equals(arr[arr.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
