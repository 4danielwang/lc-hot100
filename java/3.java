/**
 * @description: 无重复字符的最长子串: 给定一个字符串s找出其中不含有重复字符的最长子串(子串是连续的,子序列是不连续的)的长度
 * @example: abcabcbb -> 3
 * @example: bbbbb -> 1
 * @example: pwwkew -> 3
 * 思路: 滑动窗口,哈希表记录当前窗口每个字符出现次数
 */
class Solution {
    // 滑动窗口
    // 时间O(n) 空间O(p) p是字符集大小
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int left=0;
        int n = s.length();
        char ar[] = s.toCharArray();
        int cnt[] = new int[128]; // 当作hash表 统计当前窗口中的字符数量
        // 不断扩大右窗口
        for(int right=0;right<n;right++){
            char c = ar[right];
            cnt[c]++; // 当前窗口中字符c出现次数+1

            // 如果导致窗口中有重复字符 不断缩小左窗口
            while(cnt[c] > 1){
                cnt[ar[left]]--;
                left++;
            }
            // 更新最大窗口
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}