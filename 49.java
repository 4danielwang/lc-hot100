import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 把字符串分组，所有的字母除了顺序不相同，其他的都相同的分到一组

        //  计算所有单词的权重，按照ascii计算

        // map存储value, List<String>

        Map<Integer, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ar = s.toCharArray();
            int score = score(ar);
        
            List<String> list = map.getOrDefault(score, new ArrayList<>());
            list.add(s);
            map.put(score, list);
        }

        // map转为list
        return map.values().stream().toList();
    }

    // 计算分数
    public int score(char[] ar){
        int num = 0;

        for(char c : ar){
            num+=c;
        }
        return num;
    }
}