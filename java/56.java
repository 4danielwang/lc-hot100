class Solution {
    
    // 转为list 方便用Arrays排序
    private List<int[]> ans = new ArrayList<>();

    public int[][] merge(int[][] intervals) {

        // 有序序列才能用这个特性
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
    
        for(int []interval : intervals){
            int n = ans.size();
            // 当前区间与之前的还没合并完的区间有重合 合并
            if(n > 0 && ans.get(n-1)[1] >= interval[0]){
                ans.get(n-1)[1] = Math.max(ans.get(n-1)[1], interval[1]);
            }else{ // 不重合
                ans.add(interval);
            }
        }
        // 二维数组只需要第一维度大小就好
        // java二维数组 第一维度存储指向第二维度数组的指针
        // 也可以传new int[0][]
        return ans.toArray(new int[ans.size()][]);
    }
}