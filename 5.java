class Solution {
    // dp[i][j]表示s[i:j]是否是回文串
    // s[i:j]是,如果s[i]==s[j] 那s[i-1:j+1]也是
    // s长度为1 必是 长度为2 s[i:j]也是
    public String longestPalindrome(String s) {
        
        // 长度小于2
        if(s.length()<2){
            return s;
        }
            
        // 初始化dp
        boolean dp[][] = new boolean[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            dp[i][i]=true;//长度为1的都为回文
        }

       
        int begin=0; // 记录最大串开始的i
        int maxLen=1; // 最小Len就是1
        // 循环不同的串的长度 从2到s.length()都是可取范围
        for(int L=2;L<=s.length();L++){
            // 子串左边界 从0-s.length-1
            for(int i=0;i<s.length();i++){
                // 子串右边界
                int j=i+L-1; 
                // 字符串超过总串边界
                if(j>s.length()-1)
                    break;
                if(s.charAt(i)==s.charAt(j)){
                    if(L<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }
                
                // 如果是回文串 长度更大 更新maxLen和begin
                if(dp[i][j] && L>maxLen){
                    maxLen = L;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
        

    }
}