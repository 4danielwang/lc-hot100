import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 数组元素乱序，可重复
        // 找到两个元素之和等于target，返回元素index，index不能相同

        // 存储[0,j)之间的 value-index pair
        Map<Integer, Integer> map = new HashMap<>();

        for(int j=0;j<nums.length;j++){
            // 需要查找的元素
            Integer toFind = target-nums[j];
            if(map.containsKey(toFind)){
                return new int[]{map.get(toFind), j};
            }
            map.put(nums[j], j);
        }
        throw new IllegalArgumentException("no solution");
    }

}