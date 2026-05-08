/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        // 用两个7进制数模拟一个10进制数
        // 两个7进制数 一共有49个组合 每个组合概率为1/49
        // 取40个出来 每个数 1/49 映射到10个数上 让他们概率都相等 4/49
        while(true){
            // 生成2位7进制的值
            int bit2 = rand7() - 1; // 范围[0-6] 
            int bit1 = rand7() - 1; 
            int ans = bit2*7 + bit1; // 范围[0-48]
            if(ans < 40){ // 只需要[0-39]范围的数
                return (ans%10) + 1; // 范围[0-9]
            }
        }

    }
}