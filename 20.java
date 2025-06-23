import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // 长度为奇数
        if(s.length() % 2 == 1) return false;
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>(){
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        // 右括号出栈对比
        char[] ar = s.toCharArray();
        for(int i=0;i<ar.length;i++){
            // 右括号 出栈对比
            if(map.containsKey(ar[i])){
                if(stack.isEmpty() || stack.peek() != map.get(ar[i]))
                    return false;
                stack.pop();

            }else{
                stack.push(ar[i]);
            }
        }

        // 如果栈为空 成功
        return stack.isEmpty();
    }
}