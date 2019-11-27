package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No771_1 {
    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbbb";
        System.out.println(numJewelsInStones(j, s));
    }

    // accept 14 - 15ms
    public static int numJewelsInStones(String J, String S) {
        String[] arrJ = J.split("");
        String[] arrS = S.split("");
        Set<String> setJ = new HashSet<String>(Arrays.asList(arrJ));
        int count = 0;
        for (int i = 0; i < arrS.length; i++) {
            if (setJ.contains(arrS[i])) {
                count++;
            }
        }
        return count;
    }
}
