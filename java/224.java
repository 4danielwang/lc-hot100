/**
 * @description: 基本计算器,对只包括数字、括号、加号和减号的表达式求值.
 * 就是把括号去掉
 */
// 时间O(n) 空间O(n)
class Solution {
    public int calculate(String s) {
        // 记录所有括号作用域的符号,栈顶记录是当前符号括号作用域符号
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1); // 默认全局作用域的符号是正的
        int sign = 1; // 接下来要解析的数字的符号(当前括号作用域)

        int ret = 0; // 结果
        int n = s.length();
        int i = 0;
        while (i < n) {
            // 空格跳过
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign); // 进入作用域
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop(); // 出作用域
                i++;
            } else {
                // 遇到数字,可能是连续的好几个,计算数值
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}