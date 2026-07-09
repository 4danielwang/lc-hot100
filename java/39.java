/**
 * @description: candidates数组(无重复元素)和target,可以无限制重复选择candidates中的数字,返回candidates中所有和为target的组合,,不能出现重复的组合
 * @example: 输入: candidates = [2,3,6,7], target = 7 输出: [[7],[2,2,3]]
 * @example: 输入: candidates = [2,3,5], target = 8 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * @example: 输入: candidates = [2], target = 1 输出: []
 *           思路: 搜索回溯,用一个搜索树表示,左边表示不选择当前的位,右边表示选择当前的位
 */
class Solution {
    // 时间O(S) 空间O(target) S是所有可行解的长度
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    // 当前在candidates[idx]位置,还剩下target需要组合,已经组合的列表位combine,所有的组合位ans
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        // 终止条件位target<=0或者candidates被用完
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 搜索树(左子树) 不选择当前的idx位
        dfs(candidates, target, ans, combine, idx + 1);
        // 搜索树(右子树) 选择idx位
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1); // 回溯
        }
    }
}