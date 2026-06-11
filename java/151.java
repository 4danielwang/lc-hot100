/**
 * @description: 翻转字符串里的单词, 不考虑空格,翻转每个单词 trim 逆序join
 * the sky is blue -> blue is sky the
 */
// 时间O(n) 空间O(n)
class Solution {
    public String reverseWords(String s) {
        // trim去掉首尾空格
        // split regex 按照连续空格分割
        String[] ar = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=ar.length-1;i>=0;i--){
            sb.append(ar[i]);
            if(i>0){
                sb.append(" ");
            }
        }
        return sb.toString();
   }
}