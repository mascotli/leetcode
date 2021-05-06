import java.util.NoSuchElementException;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-30 13:53
 **/
public class Solution {
    /**
     * <pre>
     * Given two strings s and t which consist of only lowercase letters.
     *
     * String t is generated by random shuffling string s and then add one
     * more letter at a random position.
     *
     * Find the letter that was added in t.
     *
     * Example:
     *
     * Input:
     * s = "abcd"
     * t = "abcde"
     *
     * Output:
     * e
     *
     * Explanation:
     * 'e' is the letter that was added.
     * </pre>
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        // 假设输入都是合法的
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 0) {
                return (char) ('a' + i);
            }
        }

        throw new NoSuchElementException("could not find the difference");
    }
}
