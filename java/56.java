/**
 * @description: 合并区间：intervals是若干个区间[start, end]的集合，合并所有重叠的区间，返回不重叠的区间集合
 * 思路：把区间按照左端点排序，然后遍历区间，如果当前区间的左端点大于上一个区间的右端点将当前区间加入结果集，否则就合并当前区间和上一个区间
 */
class Solution {
    
    private List<int[]> ans = new ArrayList<>();
    // 时间(nlogn) 空间O(logn)
    public int[][] merge(int[][] intervals) {

         // 按照左端点升序排序
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
    
        for(int []interval : intervals){
            int n = ans.size();
            // 当前区间与已经合并的最后一个区间有重叠
            if(n > 0 && ans.get(n-1)[1] >= interval[0]){
                // 用当前区间右端点更新最后一个区间右端点
                ans.get(n-1)[1] = Math.max(ans.get(n-1)[1], interval[1]);
            }else{ // 不重合 直接加入结果集
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}