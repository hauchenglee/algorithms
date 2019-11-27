package leetcode;

import java.util.*;

public class No17_solution {
    public static void main(String[] args) {
        No17_solution no17_solution = new No17_solution();
        String s = null;
        Random random = new Random();
        int r1 = random.nextInt(9) + 2;
        int r2 = random.nextInt(9) + 2;
        if (r1 <= 9 && r2 <= 9) {
            String s1 = String.valueOf(r1);
            String s2 = String.valueOf(r2);
            s = s1 + s2;
        }
        System.out.println(s);
        List list = no17_solution.letterCombinations(Objects.requireNonNull(s));
        System.out.println(list);
    }

    private List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> output = new ArrayList<String>();

    private void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            // 取得第一個輸入的數字
            String letters = phone.get(digit);
            // 利用取得的數字取得對應的按鍵英文字（abc）
            for (int i = 0; i < letters.length(); i++) {
                // 拆解每一個英文字
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }
}
