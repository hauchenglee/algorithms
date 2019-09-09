package leetcode;

import java.util.HashSet;
import java.util.Set;

public class No929 {
    public static void main(String[] args) {
        String a = "HelloWorld";
        String result = a.substring(1, 6);
        System.out.println(result);
    }

    // 2019 02 12
    public int numUniqueEmails(String[] emails) {
        String beforePlus1 = null;
        String beforePlus2 = null;
        String beforePlus3 = null;

        for (String email : emails) {
            int index = email.indexOf('@');
            String beforeAt = email.substring(0, index);
            int plus = beforeAt.indexOf('+');
            String beforePlus = beforeAt.substring(0, plus);
        }

        return 0; // 避免錯誤，還沒解出來
    }

    // https://leetcode.com/problems/unique-email-addresses/discuss/186798/Java-7-liner-with-comment.
    public int numUniqueEmails_solution1(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
//            String[] parts2 = email.split('@'); error: 參數要字串
//            String s1 = email.split("@"); error: 回傳要Array
//            String s2 = email.split('@'); error: 回傳要Array + 參數要字串

            String[] local = parts[0].split("\\+");
//            String[] local2 = parts[0].split("+"); error: 沒有逃脫字元
//            String[] local3 = parts[0].split('+'); error: 參數一定要字串

            normalized.add(local[0].replace(".", "") + "@" + parts[1]);
        }
        return normalized.size();
    }

    // https://leetcode.com/problems/unique-email-addresses/discuss/186645/Java-Clean-O(n*maxStringLen)-with-and-without-split()
    public int numUniqueEmails_solution2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = getParts(email);
            String local = parseLocal(parts[0]);
            String domain = parts[1];
            set.add(local + "@" + domain);
        }
        return set.size();
    }

    private String parseLocal(String local) {
        StringBuilder sb = new StringBuilder();
        for (char c : local.toCharArray()) {
            if (c != '.') {
                if (c == '+') {
                    return sb.toString();
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String[] getParts(String email) {
        int index = 0;
        while (index < email.length() && email.charAt(index) != '@') {
            index++;
        }
        return new String[]{email.substring(0, index), email.substring(index + 1)};
    }
}
