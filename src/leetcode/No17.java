package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class No17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

        String[] arr = {"abc", "apple", "fly"};
        System.out.println(arr[1].toCharArray());
    }

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            // 2
            // 3
//            System.out.println("i: " + i);
//            System.out.println("ans.peek(): " + ans.peek());
//            System.out.println("ans.peek().length(): "+ ans.peek().length());
            while (ans.peek().length() == i) {
//                System.out.println(ans + ",,,  == " + i);
                String t = ans.remove();
//                System.out.println(t);
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }
}
