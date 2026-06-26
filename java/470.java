/**
 * @description: 用 Rand7([1-7]) 实现 Rand10([1-10])，满足等概率
 * 思路：用两个rand7和拒绝采样，模拟实现rand10
 */
class Solution extends SolBase {
    // 时间O(1) 空间O(1)
    public int rand10() {
        // 用两个7进制数模拟一个10进制数
        // 两个7进制数 一共有49个组合 每个组合概率为1/49
        // 取40个出来 每个数 1/49 映射到10个数上 让他们概率都相等 4/49
        while(true){
            // 2位7进制的值（方便计算） 最后还需要映射回1-10
            int bit2 = rand7() - 1; // [0-6] 
            int bit1 = rand7() - 1; // [0-6] 
            int ans = bit2*7 + bit1; // [0-48]
            if(ans < 40){ // 只需要[0-39]的数
                return (ans%10) + 1; // [1-10]
            }
        }

    }
}