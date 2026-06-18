/**
 * @description: 在m x n的二维字符网格board中，找出单词word是否存在于网格中,
 *               单词必须按照字母顺序，通过相邻的单元格内的字母构成(不允许重复使用同一个单元格内的字母)
 *               空间优化: 利用board本身记录访问状态,不需要单独开辟一个visited数组
 */
class Solution {
    // 时间: O(m*n*3^L), m为行数, n为列数, L为word的长度(第一步有4个方向可以走，接下来的每一步都只有3 个方向可以走)
    // 空间: O(L), L为word的长度, 递归栈的深度
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    // index是当前匹配到word的第几个字符
    // r和c是当前匹配到的board的坐标
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length())
            return true;

        // 判断越界还有当前字符是否匹配
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // 标记访问

        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp; // 回溯
        return found;
    }
}