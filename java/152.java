class Solution {
    public int maxProduct(int[] nums) {
        // fMax[i] 表示[0~i-1]的最大乘积
        // fMin[i] 表示[0~i-1]的最小乘积
        // nums[i] 当前值 可以看作一个子数组
        // 求最大乘积有三种情况 取最大 最小的就取三者最小
        // - 当前值(>0) * 上一次计算的最大值
        // - 当前值(<0) * 上一次计算的最小值
        // - 当前值

        // 先计算出i=0 方便i=1获取fMax[i-1], fMin[i-1]
        int n = nums.length;
        int[] fMax = new int[n];
        int[] fMin = new int[n];

        fMax[0] = fMin[0] = nums[0];
        for(int i=1;i<n;i++){
            fMax[i] = Math.max(fMax[i-1] * nums[i], Math.max(fMin[i-1] * nums[i], nums[i]));
            fMin[i] = Math.min(fMax[i-1] * nums[i], Math.min(fMin[i-1] * nums[i], nums[i]));
        }

        return Arrays.stream(fMax).max().getAsInt();
    }   

        // 时间优化 O(1)
        // fMax[i] 只与fMax[i-1]，当前值有关
        // fMin[i] 只与fMin[i-1]，当前值有关
        public int maxProduct(int[] nums) {
       
            int n = nums.length;
            int ans = nums[0];
            int fMax = nums[0];
            int fMin = nums[0];

            // 从i=1开始 每次计算f[i]只需要f[i-1]
            for(int i=1;i<n;i++){
                // 需要保存原来的fMax 计算fMin用到
                int mx = fMax;
                // 新的 fMax 可能是：num 本身、旧 fMax * num、或者 旧 fMin * num
                fMax = Math.max(fMax * nums[i], Math.max(fMin * nums[i], nums[i]));
                // 新的 fMin 可能是：num 本身、旧 fMax * num、或者 旧 fMin * num
                fMin = Math.min(mx * nums[i], Math.min(fMin * nums[i], nums[i]));
                ans = Math.max(ans, fMax);
            }
            return ans;
    }   
}