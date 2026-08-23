/**
 * @description: H指数，给定一位研究者论文被引用次数的数组（每篇论文被引用的次数），计算最大的H指数。
 * H指数的定义：H指数是指“有h篇论文分别被引用了至少h次”。如果没有满足条件的h，则H指数为0。
 * 思路：计数排序，满足：[i～n]的count和 >= i 的最大的i
 */
class Solution {
    // 时间O(n) 空间O(n)
    public int hIndex(int[] citations) {
        int n = citations.length;
        // 记录每个引用次数的论文数量，count[i]表示被引用了i次的论文数量
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

        // 从n开始往下找，找到第一个满足条件的i
        for(int i=n;i>=0;i--){
            ans += count[i];
            // 如果被引用了i次的论文数量加上之前的数量大于等于i，说明找到了H指数
            if(ans >= i){
                return i;
            }
        }
        return 0;
    }
}