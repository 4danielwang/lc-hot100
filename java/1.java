/**
 * @description: 两数之和,在nums中找到两个数，使它们相加等于目标值target，返回它们的下标
 */
class Solution {
    // 时间O(N) 空间O(N)
    public int[] twoSum(int[] nums, int target) {
        // 哈希表寻找值为target-x的下标 能O(1)时间找到某个值的下标
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            // target-x(nums[i]) 看能否在哈希表中找到target-nums[i] 直接返回两个下标
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            // 每访问一个元素，<值,下标> 存入哈希表
            cache.put(nums[i], i);
        }
        return new int[0];
    }
}
