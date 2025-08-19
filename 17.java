class Solution {
    // MAPPING[i] 就是数字为i的按钮的字母
    private static final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> ans = new ArrayList<>();

    // 时间O(n*4^n)
    // 空间O(n)
    public List<String> letterCombinations(String digits) {
        // 路径长度
        int n = digits.length();
        if(n == 0){
            return List.of();
        }
        
        char[] path = new char[n]; // 路径数组 记录访问按钮 当前的输出结果
        dfs(0, path, digits.toCharArray());
        return ans;
    }

    /**
      * i: 表示从digits[i~n-1]是剩下的需要递归区间
      * path: 当前已经访问的路径
      * digits: 完整的按钮字符串
     */
    private void dfs(int i, char[] path, char[] digits){
        if(i == digits.length){
            ans.add(new String(path));
            return;
        }

        // 当前访问的按钮的字母
        String letters = MAPPING[digits[i] - '0'];
        for(char c : letters.toCharArray()){
            path[i] = c;
            dfs(i+1, path, digits);
        }
    }


}