import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 转换问题 nums[j] = target-nums[i]
        // 遍历右边界j 左nums[j]遍历时候 左边的nums[i]已求得 O(1)可得
        // 通过map存储value->key映射关系

        Map<Integer,Integer> map = new HashMap<>();

        for(int j=0;j<nums.length;j++){
            if(!map.containsKey(target-nums[j])){
                map.put(nums[j], j);
            }else{
                return new int[]{map.get(target-nums[j]),j};
            }
        }
    }
}