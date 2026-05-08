class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> mapCount = new HashMap<>();

        for(int num:nums){
            mapCount.put(num, mapCount.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: mapCount.entrySet()){
            if(entry.getValue() > 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}