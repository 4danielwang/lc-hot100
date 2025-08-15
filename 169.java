import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> cnt = new TreeMap<>();

        int n = nums.length;
        for(int i : nums){
            cnt.put(i, cnt.getOrDefault(i, 0)+1);
        }
        
        // 存储最大值
        Map.Entry<Integer,Integer> ans = null;
        for(Map.Entry<Integer,Integer> entry : cnt.entrySet()){
            // 比较更大的 或者初始为null
            if(ans == null || ans.getValue() < entry.getValue()){
                ans = entry;
            }
        }
        return ans.getKey();
    }
}