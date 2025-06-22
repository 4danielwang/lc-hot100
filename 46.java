class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // 当前访问路径
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, ans);

        return ans;
    }

    // 回溯算法dfs
    // nums是原数组引用
    // path记录当前访问路径
    // ans记录所有的排列结果
    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> ans){
        if(path.size() == nums.length){
            // 注意：需要拷贝list path传递的是引用，后面改了path，全部都为[]
            ans.add(new ArrayList<>(path));
            return ;
        }


        // 进行dfs
        for(int j=0;j<nums.length;j++){
            // 跳过已经在path的元素
            if(!path.contains(nums[j])){
                path.add(nums[j]);
                dfs(nums, path ,ans);
                path.remove(path.size()-1);
            }
        }
    }

}