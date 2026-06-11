/**
 * @description: 和为k的子数组(数组的连续非空序列)的个数 前缀和+哈希表
 * [1,1,1], k=2 输出: 2
 * [1,2,3], k=3 输出: 2
 * 把区间和变成两数之差
 */
// 时间O(n) 空间O(n)
class Solution {
    // pre[j] - pre[i-1] == k => pre[i-1] == pre[j] - k
    // 有没有哪个位置的前缀和恰好等于 pre[j] - k 有的话就找到一个和为k的子数组
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        int pre=0; // 当前位置前缀和
        
        // key是前缀和,value是前缀和出现的次数
        Map<Integer,Integer> preToCount = new HashMap<>();
        // 根据定义 prefix[0]=0 一定有一个为0的前缀和 注意不要遗漏
        preToCount.put(0,1);

        for(int num : nums){
            pre += num; // 当前位置的前缀和计算
            // 去历史记录里查，有没有出现过 pre - k
            if(preToCount.containsKey(pre-k)){
                // 如果有，它出现过几次，就意味着有几个满足条件的子数组，累加到结果里
                ans += preToCount.get(pre-k);
            }
            // 把当前的前缀和也记录到哈希表中，供后面的数字使用
            preToCount.put(pre, preToCount.getOrDefault(pre, 0) + 1);
        }

        return ans;
    }
}