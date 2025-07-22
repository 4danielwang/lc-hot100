class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = searchFirstCol(matrix, target);
        if(rowIdx < 0){
            return false;
        }
        // 没有找到 返回-的
        return Arrays.binarySearch(matrix[rowIdx], target) >= 0;
    }

    // 搜索第一列元素 插入的行的行标
    private int searchFirstCol(int [][] matrix ,int target){
        int low=0,high=matrix.length-1;
        while(low<=high){
            // 向下取整
            int mid = low + (high-low)/2;
            if(matrix[mid][0] == target){
                return mid;
            }else if(matrix[mid][0] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        // 二分查找结束时 low > high 
        // low时是一个大于target的位置
        // high是第一个小于等于target的位置
        return high;
    }

}