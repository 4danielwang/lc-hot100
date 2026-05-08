class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 每次看矩阵右上角值current
        // current=target 返回
        // 判断 current < target
        // 由于每一列都是递增的 删除最后一列
        // 判断 current > target
        // 由于每一行 删除第一行

        // i,j指向行列位置
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        int j=n-1;
        
        // 未超过边界
        while(i<m && j>=0){
            int current = matrix[i][j];
            if(current == target){
                return true;
            }else if(target < current){
                --j;
            }else{
                ++i;
            }
        }

        return false;
    }
}