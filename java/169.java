/**
 * @description: 返回数组的多数元素（多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素）
 * 思路：Boyer-Moore 投票算法。
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int majorityElement(int[] nums) {
        
        int count = 0; // 多数元素出现次数
        Integer candidate = null; // 候选的多数元素

        for (int num : nums) {
            // 如果count为0，说明当前没有候选的多数元素，将当前元素作为候选
            if (count == 0) {
                candidate = num;
            }
            // 如果当前元素等于候选的多数元素，增加count，否则减少count
            count += (num == candidate) ? 1 : -1;
        }
        // 最终candidate就是多数元素
        return candidate;
    }

       
}