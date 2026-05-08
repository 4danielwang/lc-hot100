class Solution {
    private List<List<Integer>> ans = new ArrayList<>(); 

    public List<List<Integer>> subsets(int[] nums) {
        // dfs 考虑nums[i]是选还是不选
        List<Integer> path = new ArrayList<>(); //当前的路径
        dfs(0, nums, path);
        return ans;
    }
    private void dfs(int i, int[] nums, List<Integer> path){
        // 构造完毕
        if(i==nums.length){
            ans.add(new ArrayList<>(path)); // 需要复制 而不是引用
            return ;
        }
        // 不选
        dfs(i+1, nums, path);

        // 选
        path.add(nums[i]);
        dfs(i+1, nums, path);
        path.remove(path.size()-1);
    }
}