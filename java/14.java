/**
 * @description: 查找字符串数组中的最长公共前缀
 * @example: 输入: ["flower","flow","flight"] 输出: "fl"
 */
class Solution {
    // 时间O(mn) 空间O(1) n是数组长度 m是字符串平均长度
    public String longestCommonPrefix(String[] strs) {
        // 拿到第一个字符串
        // 最短公共前缀 肯定是小于等于自己的长度
        String s0 = strs[0];
        // 从左到右对比每个字符（和数组里面的每个str的相同位置进行对比）
        // i表示当前的最长公共前缀长度
        for(int i=0;i<s0.length();i++){
            char c = s0.charAt(i); // 当前对比的字符
            // 从上到下对比每个字符串中对应位置的字符
            for(String s : strs){
                // 这一列的字母缺失 s到达了末尾
                // 这一列字母不相等
                if(i == s.length() || s.charAt(i) != c){
                    return s0.substring(0,i); // 返回当前的最长公共前缀
                }
            }
        }
        // 所有字符串中都有一个公共前缀为s0
        return s0;
    }
}