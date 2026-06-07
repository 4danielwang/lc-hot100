/**
 * @description: 有效的括号
 */
class Solution {
    // 时间O(n) 空间O(n)
    public boolean isValid(String s) {
        int n = s.length();
        // 奇数长度肯定不是有效字符串
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        // 栈存储左括号，遇到右括号就弹出栈顶元素进行匹配
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                // 检查栈顶是否是对应的左括号和是否为空
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}