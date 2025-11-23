class Solution {
    // 时间O(n) 空间O(n)
    public int candy(int[] ratings) {
        // 所有学生先有1个糖
        int len = ratings.length;
        
        int []left = new int[len];
        int []right = new int[len];

        Arrays.fill(left, 1);
        Arrays.fill(right,1);
        // 从第二个人开始 计算左规则
        for(int i=1;i<len;i++){
            // 只有当前rating更大 糖+1
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
        }
        int ans = left[len-1]; // 计算总的糖果数
        // 从倒数第二个人开始 计算右规则
        for(int i=len-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1] + 1;
            }
            // 满足左右规则的最大值就是第i个同学的最少糖果
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}