import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
       // hashSet去重,不需要排序
       Set<Integer> set = new HashSet<>();
       for(int x: nums){
        set.add(x);
       }

       int maxNum = 0;
       for(Integer x : set){
        // 如果x-1在set 直接跳过，因为肯定有更长的子序列了
        if(set.contains(x-1)){
            continue;
        }
        // 不断查找x~x+y
        int longest = 1; // 当前轮的连续序列长度
        int y = x+1; //  从x+1～x+y
        // todo 可以优化掉longest变量，直接用y-x计算长度
        while(set.contains(y)){
            longest++;
            y++;
        }
        // 更新最长长度
        maxNum = Math.max(maxNum, longest);
       }

       return maxNum;

    }
}