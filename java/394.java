class Solution {
    // 用双向链表模拟栈
    // getLast addLast removeLast
    private LinkedList<String> stack = new LinkedList<>();

    public String decodeString(String s) {
        
        char[] ar = s.toCharArray();
        int i=0; // 当前读取s的位置指针
        while(i < ar.length){
            // 数字：获取连续多位数字 直接入栈
            // 字母或者左[ 直接入栈
            // 右]出栈 计算k[encoded_string]片段后 入栈
            if(Character.isDigit(ar[i])){
                // 获取连续多位数字
                StringBuilder sb = new StringBuilder();
                while(Character.isDigit(ar[i])){
                    sb.append(ar[i++]);
                }
                stack.addLast(sb.toString());
            }else if(Character.isLetter(ar[i]) || ar[i] == '['){
                stack.addLast(String.valueOf(ar[i++]));
            }else{
                // 用栈记录[]之间所有的字符串 不能直接用sb最后reverse
                // 需要保证单词逆序 而不是整体逆序 ab cd ef -> ef cd ab 而不是 fe dc ba 
                LinkedList<String> reverse = new LinkedList<>();
                while(!"[".equals(stack.getLast())){
                    reverse.addFirst(stack.removeLast()); // 取出栈顶 放入队列，逆序
                }
                // encoded_string
                String encode = String.join("", reverse);
                // 出栈[
                stack.removeLast();
                // 出栈k
                int k = Integer.parseInt(stack.removeLast());

                // 清空sb 重复利用
                // 转换 k[encoded_string]
                StringBuilder sb = new StringBuilder();
                while(k-- > 0){
                    sb.append(encode);
                }
                stack.addLast(sb.toString());
                i++;
            }
        }
        // 顺序拼接stack剩下的string
        return String.join("", stack);
    }
}