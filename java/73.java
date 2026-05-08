class Solution {
    // 思路：扫描matrix 用两个数组 分别记录某一行 某一列是否有0
    // 对有0的行和列 把他这一行/列的全部值变为0
    // 空间复杂度从O(m+n)优化到O(1) 就是需要复用已有数组的某一行 用matix值为0表示该列有0
    public void setZeroes(int[][] matrix) {
       
        int m = matrix.length;
        int n = matrix[0].length;
        // 先记录第一行和第一列是否有0
        boolean col0 = false; // 第一列是否有0
        boolean row0 = false; // 第1行是否有0 

        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                col0 = true;
            }
        }

        for(int j=0;j<n;j++){
            if(matrix[0][j] == 0){
                row0 = true;
            }
        }

         // 扫描剩下的矩阵
        for(int i=1; i<m; i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    // matrix第一行表示有0的列
                    // matrix第一列表示有0的行
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }


        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j] ==0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(col0){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }

        if(row0){
            for(int i=0;i<n;i++){
                matrix[0][i] = 0;
            }
        }
    }
}