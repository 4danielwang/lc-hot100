/**
 * @description: 字符串s(长度m)和t(长度n),返回s中的最短窗口子串(不要求连续),子串包含t的每一个字符(包括重复字符),没有找到返回空字符串
 * @example: 输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC"
 * @example: 输入: S = "a", T = "aa" 输出: ""
 *           思路:
 *           滑动窗口,left,right指针,不断扩大右窗口判断窗口的s子串是否涵盖t(涵盖:子串的每个字母出现次数都大于等于t的出现次数),如果涵盖了就不断缩小左窗口,直到不涵盖为止,记录最小的窗口
 */
class Solution {
    // 时间O(Cm+n) 空间O(C) C是字符集大小
    public String minWindow(String S, String T) {
        // 用数组记录子串窗口ASCII字母的次数
        int[] cntS = new int[128];
        // 用数组记录t字母的次数
        int[] cntT = new int[128];

        // 初始化t中每个字母的次数
        for (char c : T.toCharArray()) {
            cntT[c]++;
        }

        // 转为数组
        char[] s = S.toCharArray();
        int m = s.length;

        // 记录最小窗口的左右端点
        int ansLeft = -1;
        int ansRight = m;

        // 滑动窗口当前左右指针
        int right = 0;
        int left = 0;

        while (right < m) {
            // 右端点进入窗口
            cntS[s[right]]++;
            // 当前窗口内的字符串 是否满足涵盖关系
            while (isCover(cntS, cntT)) {
                // 找到更短的子串
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                // 左端点出窗口
                cntS[s[left]]--;
                left++;
            }
            right++;
        }
        // 求子串 右边开区间
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    // 涵盖的定义 s1的字符串中所有字符出现次数必须大于等于s2的次数
    private boolean isCover(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}