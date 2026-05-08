class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans=0;
        // 前缀最大值 左边水桶高度
        int[] pre = new int[n];
        pre[0] = height[0];
        for(int i=1;i<n;i++){
            pre[i] = Math.max(pre[i-1], height[i]);
        }

        // 后缀最大值 右边水桶高度
        int[] suf = new int[n];
        suf[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i] = Math.max(suf[i+1], height[i]);
        }

        for(int i=0;i<n;i++){
            // 可以装水 左右水桶最小值-水面高度
            ans += Math.min(pre[i], suf[i]) - height[i];
        }

        return ans;
    }
}