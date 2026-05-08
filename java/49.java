import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 把字符串分组，所有的字母除了顺序不相同，其他的都相同的分到一组

        //  不同的单词，排序后完全相同，可以分为同一组

        // map存储value, List<String>

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ar = s.toCharArray();
            // 对字符串排序
            Arrays.sort(ar);
        
            map.computeIfAbsent(new String(ar), k->new ArrayList<>()).add(s);
        }

        // map转为list
        return map.values().stream().toList();
    }

}