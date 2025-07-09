class Solution {
    public int removeDuplicates(int[] nums) {
        // hash记录元素值与位置的关系
        Map<Integer, Integer> map = new HashMap<>();

        int j=0; // 记录当前位置
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
                nums[j++] = nums[i];
            }
        }

        return j;
        
    }
}