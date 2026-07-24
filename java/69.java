/**
 * @description: 实现sqrt求x的平方根函数,不允许使用pow函数
 * 思路: 用exp和log函数计算
 */
class Solution {
    // 时间O(1) 空间O(1)
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        // 运算中浮点数误差 需要判断是ans还是ans+1
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}