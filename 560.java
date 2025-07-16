class Solution {
    // [i-j]的子数组的和 等于[0-j]-[0-i-1]的子数组前缀和
    // 然后判断他是否等于k 建立等式
    // prefixSum[m]代表[0-m]前缀和

    // 本题目标：找到prefixSum[j]-prefixSum[i]=k的所有的组合
    public int subarraySum(int[] nums, int k) {
        // 前缀和出现的次数​​
        Map<Integer,Integer> sumToCountMap = new HashMap<>();
        sumToCountMap.put(0, 1); // 空数组有一个
        int sum=0; // 计算当前前缀和
        int count=0; 

        // 遍历j的位置,查找有多少i满足条件
        for(int num : nums){
            sum += num;
            // 如果存在，说明之前有某个位置 i 使得 prefixSum[i] = sum - k
            if(sumToCountMap.containsKey(sum-k)){
                count+=sumToCountMap.get(sum-k);
            }
            sumToCountMap.put(sum, sumToCountMap.getOrDefault(sum, 0) + 1);

        }
        return count;
    }
}