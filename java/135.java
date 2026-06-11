/**
 * @description: 根据评分给孩子分糖果,求最少的糖果数量. 规则:每个孩子至少1个糖果,相邻的孩子评分高的糖果要更多(这里更多代表+1, 评分相同糖果变为1)
 * [1,0,2] 输出: 5
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1; // 累加的糖果数
        // inc 最近的递增序列的长度
        // dec 最近的递减序列的长度
        // pre 上一个孩子分的糖果数
        int inc = 1, dec = 0, pre = 1;
        // 从第二个孩子开始遍历 比较当前孩子和前一个孩子的评分
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0; // 递减序列结束
                // 如果评分相同，当前孩子只需要1个糖果；如果评分更高，必须分配pre+1个糖果
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre; // 更新当前递增序列长度
            } else {
                dec++; // 递减序列长度增加
                // 递减序列和递增序列一样长,为了满足最少1个糖果条件,因此需要把递增序列的最后一个孩子的糖果数加1
                if (dec == inc) {
                    dec++;
                }
                ret += dec; // 随着递减序列增加,之前分配的糖果数也需要递增[1],[2,1],[3,2,1]
                pre = 1; // 下坡递减 只分1个糖果
            }
        }
        return ret;
    }
}