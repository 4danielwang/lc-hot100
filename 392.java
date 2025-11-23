class Solution {
    // 双指针 时间O(n) 空间O(1)
    public boolean isSubsequence(String s, String t) {
        // 空串是任意字符串的子序列
        if(s.isEmpty()){
            return true;
        }

        // 遍历t 跳过t中不匹配的字符 如果s中所有字符匹配完毕，就说明是子序列
        int i=0;
        for(char c : t.toCharArray()){
            // 两个指针所指相等
            if(s.charAt(i) == c){
                ++i;
                if(i == s.length()){
                    return true;
                }
            }
        }
        return false;

    }
}