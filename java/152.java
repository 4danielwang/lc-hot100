/**
 * @description: 找到数组中乘积最大的非空连续子数组(至少包含一个数字),返回乘积
 *               fMax记录最大值 fMin记录最小值
 *               当遇到新的nums[i] 最大乘积有3种情况:
 *               1.自己本身
 *               2.正正得最大值 fMax
 *               3.负负得最大值 fMin
 *               fMax[i]=max(fMax[i-1]*nums[i], fMin[i-1]*nums[i], nums[i])
 *               fMin[i]=min(fMax[i-1]*nums[i], fMin[i-1]*nums[i], nums[i])
 * 
 *               空间优化:滚动数组,fMax[i] 只与fMax[i-1], fMin[i-1]和当前值有关, fMin[i]
 *               只与fMax[i-1], fMin[i-1]和当前值有关.用两个变量交替更新
 */
class Solution {

    // 时间O(n) 空间O(1)
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int ans = nums[0];
        // 初始化fMax fMin为nums[0]
        int fMax = nums[0];
        int fMin = nums[0];

        for (int i = 1; i < n; i++) {
            // 旧的fMax 下面会修改fMax
            int fMaxOld = fMax;
            fMax = Math.max(fMaxOld * nums[i], Math.max(fMin * nums[i], nums[i]));
            fMin = Math.min(fMaxOld * nums[i], Math.min(fMin * nums[i], nums[i]));
            ans = Math.max(ans, fMax);
        }
        return ans;
    }
}