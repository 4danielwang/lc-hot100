class Solution {
    
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(), 0, 0);
        return ans;
    }

    /**
     * @param n 需要的括号对数
     * @param sb 当前正在生成的括号
     * @param open sb中左括号数量
     * @param close sb中右括号的数量 
     */
    private void backtrack(int n, StringBuilder sb, int open, int close){
       // 总长度符合结束条件
       if(sb.length() == n*2){
            ans.add(sb.toString());
            return;
       }

       // 如果open还没有到n个
       if(open < n){
            sb.append('(');
            backtrack(n, sb, open+1, close);
            sb.deleteCharAt(sb.length()-1); // 回溯删掉加入的括号
       }

       // 如果close比open少
       if(close < open){
            sb.append(')');
            backtrack(n, sb, open, close+1);
            sb.deleteCharAt(sb.length()-1);// 回溯删掉加入的括号
       }
    }

}