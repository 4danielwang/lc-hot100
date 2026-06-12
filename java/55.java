/**
 * @description: 跳跃游戏,数组中的每个元素代表当前能跳跃的最大长度,判断能否跳到最后一个位置
 * [2,3,1,1,4] -> true
 */
class Solution {
    // 贪心算法: 如果x可达,x+1,x+2...x+nums[x]都可达
    // 时间O(n) 空间O(1)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0; // 能到达的最远位置

        for(int i=0;i<n;i++){
            // 位置 i 必须在我们可以到达的范围内
            if(i <= rightmost){
                // 历史最远和当前能到达的最远的最大值 更新最远位置
                rightmost = Math.max(rightmost, i+nums[i]);
                // 能跳到最后一个位置 提前结束
                if(rightmost >= n-1){
                    return true;
                }
            }
        }
        // 如果当前i超过可达范围 直接返回false
        return false;
    }
}