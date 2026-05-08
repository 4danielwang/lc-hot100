class Solution {
    // 每个部分在0-255之间
    // 不能有前导零（除非本身就是0）
    // 必须正好分成四个部分
    private List<String> ans = new ArrayList<>();
    private String ip;
    public List<String> restoreIpAddresses(String s) {
        ip = s;
        dfs(0, new ArrayList<>());
        return ans;
    }

    // path是递归的ip路径
    // start是当前递归的子串的开始index
    private void dfs(Integer start, List<String> path){
        // 合法ip
        // 已经是4部分 字符用完
        if(path.size() == 4 && start == ip.length()){
            ans.add(String.join(".", path));
            return;
        }
        
        // 如果已经分成4部分但还有剩余字符，或者字符用完但不足4部分
        // 尽早剪枝
        if(path.size() == 4 || start == ip.length()){
            return;
        }
        
        // 尝试取1-3个字符（每个段ip最多3个字符）
        // 有可能不够3个 取不了
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