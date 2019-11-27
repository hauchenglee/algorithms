package leetcode;

import java.util.HashSet;
import java.util.Set;

public class No771 {
    // accept 7ms - 9ms
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for (int j = 0; j < J.length(); j++) {
            for (int s = 0; s < S.length(); s++) {
                if (J.charAt(j) == S.charAt(s)) {
                    result++;
                }
            }
        }
        return result;
    }

    // https://leetcode.com/problems/jewels-and-stones/discuss/113553/C%2B%2BJavaPython-Set-Solution-O(M%2BN)
    public int numJewelsInStones_Solution(String J, String S) {
        int res = 0;
        Set<Character> setJ = new HashSet<Character>();
        for (char j : J.toCharArray()) setJ.add(j);
        for (char s : S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }
}
