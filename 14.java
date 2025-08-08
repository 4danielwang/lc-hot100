class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 拿到第一个字符串
        // 最短公共前缀 肯定是小于等于自己的长度
        String s0 = strs[0];
        // 从左到右对比每个字符
        for(int i=0;i<s0.length();i++){
            char c = s0.charAt(i); // 当前对比的字符
            // 从上到下对比每个字符串中对应位置的字符
            for(String s : strs){
                // 只要到末尾了 说明当前i就是最长公共前缀长度
                // 不相等 当前i就是最长公共前缀长度
                if(i == s.length() || s.charAt(i) != c){
                    return s0.substring(0,i);
                }
            }
        }
        // 所有字符串中都有一个公共前缀为s0
        return s0;
    }
}