class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 有序数组可以用双指针
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int len = nums.length;

        // 留下2个位置给j,k，x循环n-2次
        for (int i = 0; i < len - 2; i++) {
            // 不能有重复的三元组 跳过
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 两数之和的left right
            int j = i + 1;
            int k = len - 1;
            // 优化1：nums[i] 与后面最小的两个数相加 >0 跳过
            if(nums[i]+nums[i+1]+nums[i+2]>0)
                break;
            // 优化2：nums[i] 与后面最大的两个数相加 <0 跳过
            if(nums[i]+nums[len-2]+nums[len-1]<0)
                continue;

            // 解决i已经固定，寻找j和k满足nums[i] + nums[j] + nums[k]=0
            while (j < k) {
                int res = nums[i] + nums[j] + nums[k];
                if (res > 0) {
                    k--;
                } else if (res < 0) {
                    j++;
                } else {
                    // 如果找到一组 就往中间缩减left right
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    // 优化：去掉重复
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    k--;
                    // 优化：去掉重复
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }

        }
        return list;

    }
}