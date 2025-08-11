class Solution {
    // 就是计算 [0~i-1]乘积 * [i+1~n-1]乘积
    // pre[i]代表nums[0~i-1]乘积
    // suffix[i]代表nums[i~n-1]乘积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
       
        // 前缀乘积数组
        int[] pre = new int[n];
        pre[0] = 1;
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] * nums[i-1];
        }

        // 后缀乘积数组
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        // 计算结果
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = pre[i] * suffix[i];
        }

        return ans;
    }


    // 优化空间复杂度
    // 输出数组不计算 只用一个数组来保存结果
    // 先计算suffix pre只用一个变量保存 循环计算pre的时候 计算ans，结果保存在suffix中
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        // suffix[i] 做为 ans[i]
        int pre = 1; // 这里的pre就代表上面的pre[i]
        for(int i=0;i<n;i++){
            suffix[i] *= pre; // 等于上面的ans(suffix[i]) = pre[i] * suffix[i]
            pre *= nums[i]; // 计算pre[i+1]
        }

        return suffix;
    }

}