/**
 * @description: 旋转图像，n x n 的二维矩阵表示一个图像。图像顺时针旋转 90 度,原地旋转
 */
class Solution {
    // 时间O(n^2) 空间O(1)
    public void rotate(int[][] matrix) {
        // 顺时针旋转90 拆为两个动作
        // 1、垂直对称翻转
        // 2、主对角线翻转
        flip1(matrix);
        flip2(matrix);
    }

    // 垂直对称轴翻转
    // (0,0)->(n-1,0)
    // m[i][j] -> m[n-i-1][j]
    private void flip1(int[][] matrix){
        int n=matrix.length;

        // 只需要对一半的列进行翻转 全部翻转的话就是2次翻转了
        for(int i=0;i<n/2;i++){
            int m=matrix[i].length;
            for(int j=0;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;       
            }
        }
    }
    
    // 主对角线翻转
    // m[i][j] -> m[j][i]
    private void flip2(int[][] matrix){
        // 只需要遍历上三角
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}