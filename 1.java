class Solution {
    // 时间O(N) 空间O(N)
    public int[] twoSum(int[] nums, int target) {
        // 哈希表寻找 target - x 只需要O(1)时间
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            // 访问一个元素，存储<值,位置>哈希表
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
