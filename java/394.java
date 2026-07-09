/**
 * @description: 给定一个经过编码的字符串，返回它解码后的字符串。编码规则为:
 *               k[encoded_string]，表示encoded_string重复k次
 * @example: 输入: s = "3[a]2[bc]" 输出: "aaabcbc"
 * @example: 输入: s = "3[a2[c]]" 输出: "accaccacc"
 *           思路: 递归从左到右解析字符串
 */
class Solution {
    String src;
    int ptr; // 当前解析到的位置

    // 时间O(S) 空间O(n) S是解码后字符串的长度 n是编码字符串s的长度
    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        // 终止条件: ptr到达字符串末尾或者遇到右括号
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }

        char cur = src.charAt(ptr);
        // 重复次数k
        int repTime = 1;
        String ret = "";

        // 当前位是数字位
        if (Character.isDigit(cur)) {
            // 解析出数字
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 递归解析String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 解码重复k次的字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // 当前位是字母位
            ret = String.valueOf(src.charAt(ptr++));
        }
        // 递归解析剩余的字符串
        return ret + getString();
    }

    // 解析出连续数字k
    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}