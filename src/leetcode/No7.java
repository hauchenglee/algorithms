package leetcode;

/**
 *
 */

public class No7 {
    public static void main(String[] args) {
        No7 no7 = new No7();
        int ans = no7.reverse_int(0);
        System.out.println(ans);

        long ans_s1 = no7.reverse_string(-9646324351L);
        long ans_s2 = no7.reverse_string(0);
        System.out.println(ans_s1);
    }

    public int reverse_int(int x) {
        String ans = "";
        int store = x;
        if (x != 0) {
            x = Math.abs(x);
            while (x != 0) {
                ans += Integer.toString(x % 10);
                x = x / 10;
            }
        }
        if (ans.length() != 0) {
            if (store > 0) {
                return Integer.parseInt(ans);
            } else {
                return (Integer.parseInt(ans) * -1);
            }
        } else {
            return 0;
        }
    }

    public long reverse_string(long x) {
        long store = x;
        String rev = Long.toString(Math.abs(x));
        StringBuilder sb = new StringBuilder(rev);
        sb.reverse();
        if (store >= 0) {
            return (int) Long.parseLong(String.valueOf(sb));
        } else {
            return Long.parseLong(String.valueOf(sb)) * -1;
        }
    }
}
