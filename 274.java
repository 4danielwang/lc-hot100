class Solution {
    // 计数排序，满足：[i～n]的count和 >= i 的最大的i
    // 时间O(n) 空间O(n)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int count[] = new int[n+1];
        int ans = 0;

        for(int citation : citations){
            // 大于n的 一律当作n
            if(citation >= n){
                count[n]++;
            }else{
                count[citation]++;
            }
        }

        // 求最大i 从大往小的找
        for(int i=n;i>=0;i--){
            ans += count[i];
            if(ans >= i){
                return i;
            }
        }
        return 0;
    }
}