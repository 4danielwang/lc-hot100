/**
 * @description: 给定两个字符串形式的非负整数num1和num2，计算它们的和，并以字符串形式返回
 * @example: 输入: num1 = "11", num2 = "123" 输出: "134"
 * 思路： 然后从末尾到开头逐位相加，注意进位即可
 */
class Solution {
    // 时间O(n) 空间O(n) n是两个字符串的最大长度
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}