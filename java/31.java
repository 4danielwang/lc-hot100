/**
 * @description: 找到按字典序大小排序的下一个排列
 * 思路：尽可能改变靠右的数组，把右边较小的数，和它后面较大的数交换。交换后，剩下的右边部分要尽可能小。
 * [4,5,2,6,3,1] -> [4,5,3,6,2,1] -> [4,5,3,1,2,6]
*/

class Solution {

    // 两轮扫描
    // 时间O(N) 空间O(1)
    public void nextPermutation(int[] nums) {
        // 初始指向倒数第二个元素
        int i = nums.length-2;
        // 从后往前找第一个nums[i] < nums[i+1]的元素,说明后面的都是降序（最大排列）
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        // 对于找到i的情况，先找到比他大的j，进行交换后再翻转，如果没找到直接翻转（[321] -> [123]）
        if(i>=0){
            int j=nums.length-1;
            // 从后往前找第一个大于等于nums[i]的元素
            while(j>=i && nums[j]<= nums[i]){
                j--;
            }
            // 交换i和j
            swap(nums, i, j);
        }
        // 翻转i后面的元素
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 把数组从left开始到末尾进行首位翻转
    private void reverse(int[] nums, int left){
        int right = nums.length-1;
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}