/**
 * @description: 判断子序列
 * @example: s = "abc", t = "ahbgdc" -> true
 * @example: s = "axc", t = "ahbgdc" -> false
 * 思路：双指针。i指向s，j指向t。遍历t，如果t[j] == s[i]，则i++，否则j++。如果i走到s的末尾，则说明s是t的子序列。
 */
class Solution {
    // 双指针 时间O(n) 空间O(1)
    public boolean isSubsequence(String s, String t) {
        // 空串是任意字符串的子序列
        if(s.isEmpty()){
            return true;
        }

        // 遍历t 跳过t中不匹配的字符 如果s中所有字符匹配完毕，就说明是子序列
        int i=0;
        for(int j=0;j<t.length();++j){
            // 两个指针所指相等
            if(s.charAt(i) == t.charAt(j)){
                ++i;
                if(i == s.length()){
                    return true;
                }
            }
        }
        return false;

    }
}