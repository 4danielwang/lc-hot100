import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        // 1. 边界条件判断
        if(nums==null || nums.length<3) return list;

        // 2. 排序，两数，三数之和的双指针都是在有序数组的条件下实现的
        Arrays.sort(nums);

        
        // i<j<k
        // 把nums[i]当作两数之和的固定数，判断 nums[i]+nums[j]+nums[k]=0 => nums[i] = -(nums[j]+nums[k])
        // 对每个nums[i]都需要找到j和k

        // 扫描nums.length-2轮
        for(int i=0;i<nums.length-2;i++){
           
            // 因为有序，nums[i]大于0
            // 一定不满足nums[i]+nums[j]+nums[k]=0
            if(nums[i]>0){
                break;
            }

            // 去重 nums[i]和上一轮一样 直接跳过
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j=i+1; // 代表有序搜索空间的左边界 从i的右边1个开始
            int k=nums.length-1; // 代表有序搜索空间的右边界，从nums最末尾开始

            // 不断缩减搜索空间
            while(j<k){
                // 判断三数之和为0
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 对nums[j]旁边的元素去重，跳过后面几个和num[j]相同的元素
                    while(j<k && nums[j] == nums[j+1]) j++;
                    // 对nums[k]旁边的元素去重
                    while(j<k && nums[k] == nums[k-1]) k--;
                    // 满足==0条件，由于有序性同时缩减左右的搜索边界
                    j++;
                    k--;
                }else if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }
            }
            
        }
        return list;
    }

        public List<List<Integer>> threeSum2(int[] nums) {
        // 数组排序 才能用相向指针
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int len = nums.length; // 数组长度
        // 留下2个位置给j,k，x循环n-2次

        // 数组有序
        for (int i = 0; i < len - 2; i++) {
            // 如果和上一轮一样 直接跳过
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 两数之和的left right
            int j = i + 1;
            int k = len - 1;
            // optional 优化1：首三个都大于0 直接pass
            // if(nums[i]+nums[i+1]+nums[i+2]>0)
            //     break;
            // optional 优化2
            // if(nums[i]+nums[len-2]+nums[len-1]<0)
            //     continue;
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
                    // 重复的去掉
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    k--;
                    // 重复的去掉
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }

        }
        return list;

    }

}