class Solution {
    public String minWindow(String S, String T) {
        // 字符出现个数 虽然这里只有大小写 但是扩大范围 他们都是ascii
        int[] cntS = new int[128];
        int[] cntT = new int[128];

        // 初始化cntT
        for(char c:T.toCharArray()){
            cntT[c]++;
        }

        // 转为数组
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        // S的窗口左右指针
        int right=0;
        int left=0;
        int m = s.length;
        // 最小涵盖的子串的左右窗口值 如果找不到 就是初始值-1
        int ansLeft=-1;
        int ansRight=m;
        while(right<m){
            //右端点进入窗口
            cntS[s[right]]++;
            // 当前窗口内的字符串 是否满足涵盖关系
            while(isCover(cntS, cntT)){
                if(right-left < ansRight-ansLeft){
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[s[left]]--;
                left++;
            }
            right++;
        }
        // 求子串 右边开区间
        return ansLeft < 0 ? "":S.substring(ansLeft, ansRight + 1);
    }

    // 涵盖的定义 s1的字符串中所有字符出现次数必须大于等于s2的次数
    // 判断所有的ascii的字母 如果任何一个cntS中次数小于cntT就不是涵盖
    private boolean isCover(int[] cntS, int[] cntT){
        for(int i='A';i<='Z';i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }

        for(int i='a';i<='z';i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }
        return true;
    }
}