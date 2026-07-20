/**
 * @description: 找到字符串s中的最长回文子串
 * @example: babad -> bab
 * @example: cbbd -> bb
 */
class Solution {
  // 时间O(N^2) 空间O(1)
  // 中心扩展法
  public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        // 枚举所有可能的回文中心 不断地向两边扩展子串，两边的字母相同就继续扩展
        for (int i = 0; i < s.length(); i++) {
            // 可能有两种情况：长度为1和长度为2的回文中心
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // 记住回文子串的起始位置和结束位置
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    // 从中心向两边扩展，找到最长回文子串的长度
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}