/**
 * @description: 根据数组nums,返回所有可能的不重复的子集
 * @example: [1,2,3] => [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *           每个数字只有选或者不选两种情况,并且不能重复,可以用dfs访问数组,每次讨论选或者不选
 */
class Solution {
    // 时间O(n*2^n) 空间O(n)
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 当前的访问路径
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, path);
        return ans;
    }

    // 讨论nums[i]是否加入path, 选或者不选
    private void dfs(int i, int[] nums, List<Integer> path) {
        // 构造完毕
        if (i == nums.length) {
            ans.add(new ArrayList<>(path)); // 需要复制 而不是引用
            return;
        }
        // 不选i
        dfs(i + 1, nums, path);
        // 选
        path.add(nums[i]);
        dfs(i + 1, nums, path);
        // 回溯
        path.remove(path.size() - 1);
    }
}