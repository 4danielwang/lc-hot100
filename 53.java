
class Solution {

    public int maxSubArray(int[] nums) {
        // 由于f[i]只由f[i-1]决定 可以优化存储空间
        int f=0;
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            f = Math.max(f,0) + nums[i];
            ans = Math.max(ans, f);
        }

        return ans;
    }


    // f[i]是以i结尾的数组的最大字数组和
    public int maxSubArray2(int[] nums) {
        int f[] = new int[nums.length];

        f[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            f[i] = Math.max(f[i-1], 0) + nums[i];
        }

        // 求出最大值
        return Arrays.stream(f).max().getAsInt();
    }
}