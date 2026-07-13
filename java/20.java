/**
 * @description: 有效的括号，判断只包括左右括号的字符串是否有效
 * @example: "()"、"()[]{}"、"{[]}" 是有效的，"(]"、"([)]" 是无效的
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
        // 遇到左括号入栈，遇到右括号就弹出栈顶元素进行括号对匹配
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                // 检查栈顶是否和当前的右括号匹配或者为空栈
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop(); // 括号匹配出栈
            } else {
                stack.push(ch); // 左括号入栈
            }
        }
        return stack.isEmpty();
    }
}