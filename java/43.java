/**
 * @description: 两个字符串数字乘积,返回字符串,不能用BigInteger和库
 */
class Solution {
    // 时间O(m*n) 空间O(m+n)
    public String multiply(String num1, String num2) {
        // 特殊情况处理：只要有一个是0，结果就是0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        // 结果的最大长度为 m + n
        int[] res = new int[m + n];

        // 从个位数开始逐位相乘
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 算出当前两个字符的乘积
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // num1[i]*num2[j]的结果分别在res中对应的两个位置res[i+j]和res[i+j+1]
                int p1 = i + j; // 高位（进位）
                int p2 = i + j + 1; // 低位

                // 将乘积加上当前低位已经存在的值（可能来自上一次计算的进位）
                int sum = mul + res[p2];

                // 更新低位和高位
                res[p2] = sum % 10;
                res[p1] += sum / 10; // 注意这里是 +=，因为高位可能本来就有值
            }
        }

        // 将结果数组转化为字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            // 忽略前导 0（由于我们分配了 m+n 的空间，首位极有可能是 0）
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }

        return sb.toString();
    }
}