/**
 * @description: 找到只出现一次的数字
 * 思路：用map统计每个元素出现的次数，最后找到出现次数为1的元素
 */
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();

        // 统计每个元素的值和出现次数
        for(int num : nums){
            mapCount.put(num, mapCount.getOrDefault(num, 0) + 1);
        }

        // 访问entrySet 找到出现次数为1的num
        for(Map.Entry<Integer, Integer> entry : mapCount.entrySet()){
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}