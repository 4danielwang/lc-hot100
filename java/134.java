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
        return s<0 ? -1:ans; // 走一圈油量<0是情况2
    }
}