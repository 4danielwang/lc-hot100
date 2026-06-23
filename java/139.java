/**
 * @description: 字符串s,字典wordList,判断s是否可以由wordList中的单词组成(不要求必须使用wordList的词,可以重复使用同一个单词)
 *               dp[i]表示字符串s[0..i−1]按照空格拆分的单词是否都在字典中
 *               dp[i]=dp[j] && check(s[j..i−1])
 *               含义:
 *               对于s[0...i-1]的每个位置j,如果s[0...j-1]在字典中,并且s[j..i−1]在字典中,s[0...i-1]在字典中
 *               => dp[i] = true
 */
public class Solution {
    // 时间O(n^2) 空间O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // 初始条件
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 找到[0...i-1]的每个位置j s[j....i-1]在字典中,并且s[0...j-1]在字典中
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}