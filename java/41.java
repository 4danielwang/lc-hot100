/**
 * @description: 在未排序的nums数组找到没有出现的最小正整数
 * 思路：置换，恢复数组，如果数组包含1~n的整数x，置换回到x-1的下标位置，置换完成后遍历数组找到第一个不连续的座位号（或者n+1)
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            // 置换，恢复数组 需要避免nums[i] = x = nums[x-1]的情况导致死循环
            while(nums[i] >= 1 && nums[i] <=n && nums[i] != nums[nums[i]-1]){
                int j = nums[i]-1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}