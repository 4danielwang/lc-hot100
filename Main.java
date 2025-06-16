import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        Map<Character, Integer> counter = new HashMap<>();

        char[] arr = s.toCharArray();
        int left=0;
        for(int right=0;right<arr.length;right++){
            char c = arr[right];
            counter.put(c, counter.getOrDefault(c,0)+1);
            while(counter.get(arr[right]) >1){
                counter.put(arr[left], counter.get(arr[left])-1);
                left++;
            }
            res = Math.max(res, right-left+1);
        }

        return res;

    }
}