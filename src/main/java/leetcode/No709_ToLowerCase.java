package leetcode;

public class No709_ToLowerCase {
    public static void main(String[] args) {
//        System.out.println(toLowerCase_withoutAPI("\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\""));
//        System.out.println(toLowerCase_withoutAPI("ABab+-"));
//        System.out.println(toLowerCase_withoutAPI("\"here\""));
        System.out.println(toLowerCase_withoutAPI("\"LOVELY\""));
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    // upper to lower
    public static String toLowerCase_withoutAPI(String str) {
        String strAnswer = "";
        if (str == null || str.trim().length() == 0) {
            return str;
        } else {
            for (int i = 0; i < str.length(); i++) {
                for (int j = 65; j <= 90; j++) {
                    char upper = (char) j;
                    char lower = (char) (j + 32);
                    if (str.charAt(i) != upper) {
                        System.out.println("str.charAt(i)" + str.charAt(i));
                    }
//                    System.out.println("char lower = (char) (j + 32);" + upper);
//                    if (str.charAt(i) != upper) {
////                        System.out.println("~~");
//                        strAnswer += str.charAt(i);
//                        break;
//                    } else if (str.charAt(i) == upper) {
//                        System.out.println("str.charAt(i) == upper "+lower);
//                        strAnswer += lower;
//                        break;
//                    }
                }
            }
            return strAnswer;
        }
    }

    // https://leetcode.com/problems/to-lower-case/discuss/189996/Java-beats-100.-Unlike-most-posts-actually-correct-across-character-sets-and-locales
    // Some people seem to think using the built-in method String.toLowerCase() is "cheating" or something.
    // And yet their "solutions" do not correctly handle anything other than their narrow language case.
    // The whole world doesn't use only american english.
    // Other character sets are used.
    // Other definitions of what "lowercase" means are used.
    // Simply adding a constant to ASCII characters 'A'-'Z' isn't really a solution to lowercasing text,
    // and outside of a very limited context will give the wrong answer.
    //
    // You could spend huge amounts of effort trying to recreate all the logic for lowercasing all the different character sets, languages, and locales of the world...
    // but that would not be an "easy" problem. Using the built-in function that already accounts for characters outside of the limited ASCII case,
    // and how locale-specific rules interact with them, is clearly the only answer that is both correct and efficient.
}
