class Solution {
    
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(0, target, candidates, new ArrayList<>());
        return ans;    
    }

    /**
      * i 当前还能选择的区间[i-n]
      * left 剩余需要凑的target
      * candidates 候选数组
      * path：已经选择的访问路径
     */
    private void dfs(int i, int left, int[] candidates, List<Integer> path){
        // 成功找到一个路径
        if(left == 0){
            // 使用数组拷贝 不能用引用
            ans.add(new ArrayList<>(path));
            return;
        }

        // 超过candidate范围
        // 找不到符合条件的target
        if(left < 0 || i == candidates.length){
            return;
        }

        // 不选
        dfs(i+1, left, candidates, path);

        // 选
        path.add(candidates[i]); //  记录选的路径
        dfs(i, left-candidates[i], candidates, path);
        path.remove(path.size()-1); // 回溯
    } 
}