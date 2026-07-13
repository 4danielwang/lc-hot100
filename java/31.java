/**
 * @description: 找到按字典序大小排序的下一个排列（能够找到一个大于当前序列的新序列，且变大的幅度尽可能小）
 * 思路：把左边一个较小的数和右边一个较大的数交换，较小数尽可能靠右，较大的数尽可能的小，然后把较大数右边（不包括自己）的数升序排列
 * 输入 [4,5,2,6,3,1] -> 交换 [4,5,3,6,2,1] -> 输出 [4,5,3,1,2,6]
*/
class Solution {
    // 两轮扫描
    // 时间O(N) 空间O(1)
    public void nextPermutation(int[] nums) {
        // 初始指向倒数第二个元素 防止i+1越界
        int i = nums.length-2;
        // 从后往前找第一个nums[i] < nums[i+1]的元素,说明后面的都是降序（最大排列）
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        // 对于找到i的情况，先找到比他大的j，进行交换后再翻转
        // 如果没找到直接翻转 翻转[i+1,n)
        if(i>=0){
            int j=nums.length-1;
            // 在区间[i+1, n)找第一个大于等于nums[i]的元素
            while(j>=i && nums[j]<= nums[i]){
                j--;
            }
            // 交换i和j
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 把数组从left开始到末尾进行首尾元素交换
    private void reverse(int[] nums, int left){
        int right = nums.length-1;
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}