import java.util.Set;

/**
 * @description: 未排序的数组中,找出数字连续的最长序列的长度(只要能找到连续的数字就算连续,不要求数组中排序是连续的)
 *               快速跳过不是连续序列的数字,只从连续序列的起点开始查找 当遇到num判断num-1不在nums里面,num就是起点
 * @example: [100, 4, 200, 1, 3, 2] => [1, 2, 3, 4] => 输出4
 */
class Solution {
    // 时间O(n) 空间O(n)
    public int longestConsecutive(int[] nums) {
        // hashSet去重
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        int ans = 0;
        for (Integer num : set) {
            // 只对连续序列的“起点”进行匹配 num-1存在则是起点
            if (!set.contains(num - 1)) {
                int longest = 1; // 当前序列长度
                int currentNum = num; // 当前序列最大数字

                // 不断往后找连续的数字
                while (set.contains(currentNum + 1)) {
                    longest++;
                    currentNum++;
                }
                // 更新最长长度
                ans = Math.max(ans, longest);
            }
        }

        return ans;

    }
}