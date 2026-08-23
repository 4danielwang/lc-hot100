/**
 * @description: 判断一个字符串是否是回文串，只考虑字母和数字字符，忽略大小写
 * 思路：双指针，左指针从左往右扫描，右指针从右往左扫描，遇到非字母数字的字符就跳过，直到两个指针相遇
 */
class Solution {
    // 双指针 时间O(n) 空间O(1)
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        // 双指针相遇则退出
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                // 左指针非字母或者数字
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){  
                // 右指针非字母或者数字
                j--;
            }else if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                // 左右指针相等
                i++;
                j--;
            }else{
                // 左右指针不等
                return false;
            }
        }
        return true;
    }
}