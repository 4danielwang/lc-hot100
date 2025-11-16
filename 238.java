class Solution {
    // 时间O(n) 空间O(1)
    // ans[i] = L[i] * R[i] L和R分别是左右侧数组的乘积
    // 优化空间，先算L，用一个变量当作R，乘上得到ans
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];

        ans[0] = 1; // 初始化L[0]
        // L[i] = nums[i] * L[i-1]
        for(int i=1;i<ans.length;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int R = 1; // 初始化R[nums.length-1] 把R数组优化为了一个变量
        for(int i=nums.length-1;i>=0;i--){
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        return ans;
    }
}