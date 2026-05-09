/**
 * @description: 两数之和,在nums中找到两个数，使它们相加等于目标值target，返回它们的下标
 */
class Solution {
    // 时间O(N) 空间O(N)
    public int[] twoSum(int[] nums, int target) {
        // 哈希表寻找值为target-x的下标 O(1)
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            // 要寻找的值为target-x(nums[i])
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            // 访问一个元素，存储<值,位置>哈希表
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
