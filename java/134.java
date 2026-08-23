/**
 * @description: 加油站问题，给定两个数组gas和cost，gas[i]表示第i个加油站的汽油量，cost[i]表示从第i个加油站到下一个加油站消耗的汽油量，问是否存在一个起点可以走一圈，如果存在返回起点的索引，否则返回-1
 * 1. 如果gas之和小于cost之和，那么一定不存在答案
 * 2. 如果gas之和大于等于cost之和，那么一定存在答案
 * 3. 画出折线图，找到折线图的最低点，从这个点开始走一圈，一定不会出现负的油量
 */
class Solution {
    // 时间O(n) 空间O(1)
    // 两种情况：gas之和大于等于cost之和 一定存在答案，小于的话一定不存在
    // 画出折线图 找到折线图最低点，就是答案，从这个点走一圈，一定不会出现负的油量
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s = 0; // 当前油量
        int minS = 0; // 行程中最小油量
        int ans = 0; // 最小油量所处的加油站位置

        for(int i=0;i<gas.length;i++){
            s += gas[i] - cost[i]; // 在第i处加油 然后从i走到了i+1
            if(s < minS){
                minS = s; // 更新当前油量
                ans = i+1; // 更新当前车的位置
            }
        }
        return s<0 ? -1:ans; // 走一圈油量<0一定不存在
    }
}