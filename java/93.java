/**
 * @description: 根据字符串,复原所有可能的合法IP地址。一共4个部分,每个部分在0-255之间.不能有前导零（除非本身就是0）
 * @example: 输入: "25525511135" 输出: ["255.255.11.135","255.255.111.35"]
 */
// 时间O(3^4) 空间O(1)
class Solution {
    private List<String> ans = new ArrayList<>();
    private String ip;
    public List<String> restoreIpAddresses(String s) {
        ip = s;
        dfs(0, new ArrayList<>());
        return ans;
    }

    // path是当前已经分好的ip段
    // start是还没遍历的字符串的起始位置
    private void dfs(Integer start, List<String> path){
        // 合法ip 4个ip段都找到 所有字符遍历完
        if(path.size() == 4 && start == ip.length()){
            ans.add(String.join(".", path));
            return;
        }
        
        // 剪枝: 如果已经分成4部分但还有剩余字符，或者字符用完但不足4部分
        if(path.size() == 4 || start == ip.length()){
            return;
        }
        
        // 尝试取1-3个字符（每个段ip最多3个字符） 
        // 需要判断剩下的字符串是否足够取 有可能不够
        for(int len=1;len<=3 && start + len <=ip.length();len++){
            String seg = ip.substring(start, start+len); // 当前段ip
            // 如果取出来的是合法ip 再继续dfs
            if(validIpAdddr(seg)){
                path.add(seg);
                dfs(start+len, path);
                path.remove(path.size()-1); // 回溯
            }
            
        }
    }

    // 判断是否合法ip
    private boolean validIpAdddr(String s){
        // 不能有前导零 0的话只能是本身单独的0
        if(s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        int val = Integer.parseInt(s);
        return val>=0 && val <=255;
    }
}