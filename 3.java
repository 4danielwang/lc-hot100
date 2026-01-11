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
            cnt[c]++;

            // 如果窗口中有重复字符 缩小左窗口
            while(cnt[c] > 1){
                cnt[ar[left]]--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}