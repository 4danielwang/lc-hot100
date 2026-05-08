class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n-1, memo, nums);
    }
    
    // 子问题：i不偷 dfs(i-1)，i偷 dfs(i-2)
    //  越界 i<0
    private int dfs(int i, int[] memo, int[] nums){
        if(i<0){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }
        return memo[i] = Math.max(dfs(i-1,memo,nums),dfs(i-2,memo,nums)+nums[i]);
    }
}

class Solution {

    // 空间复杂度O(n)
    // 根据递归方法：表达式 1:1翻译成递推
    // f[i] = Math.max(f[i-1],f[i-2]+nums[i]) i:0~n-1
    // 为了方便计算 不计算负的下标 把数组长度+2整体偏移 i:0~n-1
    // 但是这里nums[i]不需要变为nums[i+2] num[i]代表循环中的每个num的值 不能越界 
    // f[i+2] = Math.max(f[i+1], f[i]+nums[i+2])
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+2];

        for(int i=0;i<n;i++){
            f[i+2] = Math.max(f[i+1], f[i]+nums[i]);
        }
        return f[n+1];
    }
    

    // 空间复杂度O(1)
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+2];
        // f[i+2]只依赖于f[i+1],f[i] 并且是不断覆盖更新的
        // 用3个变量存储f0,f1,f2
        // f2 代表新计算的下一个f
        // f1 代表f2的上一个f
        // f0 代表f1的上上一个f
        int f0=0,f1=0,f2=0;
        for(int i=0;i<n;i++){
            f2 = Math.max(f1, f0+nums[i]); // 计算下一个f
            f0 = f1; // 更新上上一个f 为上一个f
            f1 = f2; // 更新下一个f 为上一个f
        }
        return f1;
    }
}
