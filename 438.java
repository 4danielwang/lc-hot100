class Solution {
    // 固定窗口大小 滑动窗口
    // 滑动窗口要用数组实现
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计p窗口 各种字符出现的个数
        int[] cntS = new int[26]; // 统计s'窗口 各种字符的出现个数

        
        // 初始化p窗口计数
        for(int i=0;i<p.length();i++){
            cntP[p.charAt(i)-'a']++;
        }

        // j是左窗口 i是右窗口
        // 从右侧开始 窗口扩大
        for(int i=0;i<s.length();i++){
            // s'窗口右侧扩大 窗口计数器更新
            cntS[s.charAt(i)-'a']++;

             int j = i-p.length()+1;
             if(j<0){
                continue; // 子串还没达到p的长度
             }
             // 对比两个窗口计数器数组 值相等
             if(Arrays.equals(cntP, cntS)){
                ans.add(j);
             }
             // s'窗口左侧缩小 窗口计数更新
             cntS[s.charAt(j)-'a']--;

        }
       return ans;
    }
}
