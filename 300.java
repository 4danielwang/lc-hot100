class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0) return 0;

        // LIS：严格递增子序列
        // lisLen[i]表示以nums[0]~nums[i]区间的子数组中 LIS最大长度
        // lisLen[i]默认值为1
        int lisLen[] = new int[nums.length];
        Arrays.fill(lisLen,1);
        int ans=1;

        // 外层是数组长度
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                // 比较两个数的大小
                // 实际上只有两个数挨在一起并且前面小于后面的时候才会更新
                if(nums[j] < nums[i]){
                    lisLen[i] = Math.max(lisLen[i], lisLen[j]+1);
                }
            }
            ans = Math.max(ans, lisLen[i]);
        }
        return ans;


    }
}