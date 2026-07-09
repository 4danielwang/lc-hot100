/**
 * @description: 生成所有可能的有效的括号组合,n是括号的对数
 * @example: 输入: n = 3 输出: ["((()))","(()())","(())()","()(())","()()()"]
 *           思路: dfs+回溯
 */
class Solution {
    // 时间复杂度：O(4^n / sqrt(n))  空间 O(n)
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        dfs(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    // 如果左括号<n,可以放左括号,如果右括号<左括号,可以放右括号,长度达到2*n时,左右括号个数相等,是有效的括号
    // left:当前左括号个数,right:当前右括号个数,max:括号对数
    public void dfs(List<String> ans, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append('(');
            dfs(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1); // 回溯 删掉左括号
        }
        if (right < left) {
            cur.append(')');
            dfs(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1); // 回溯 删掉右括号
        }
    }
}