/**
 * @description: 爬楼梯每次可以爬1或2阶，求n阶楼梯有多少种爬法
 * f[n] = f[n-1] + f[n-2]
 * 滚动数组 空间优化：f[n]只与f[n-1]和f[n-2]有关，所以可以用两个变量来保存这两个值，空间复杂度O(1)
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int climbStairs(int n) {
       // f(1) = 1, f(2) = 2
       if (n<=2){
        return n;
       }

       int prev2 = 1; // f(n-2)
       int prev1 = 2; // f(n-1)

       for(int i=3; i<=n; i++){
        int current = prev1 + prev2; // f(n) = f(n-1) + f(n-2)
        prev2 = prev1; // 更新f(n-2)
        prev1 = current; // 更新f(n-1)
       }

       return prev1; // 返回f(n-1)
    }

}