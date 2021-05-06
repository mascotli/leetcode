import java.util.Arrays;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-28 15:38
 **/
public class Solution {
    public int totalNQueens(int n) {
        int[] result = {0};

        if (n < 1) {
            return result[0];
        }

        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = new char[n];
            Arrays.fill(board[i], '.');
        }

        solveNQueens(board, 0, result);
        return result[0];
    }

    private void solveNQueens(char[][] board, int row, int[] result) {
        if (board.length == row) {
            result[0]++;
        }

        for (int col = 0; col < board.length; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueens(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean canPlace(char[][] board, int row, int col) {
        // 检测之前的列上是否已经放过皇后
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 45度角(左下角)上是否已经存在过皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 135度角上（左上角）是否已经存在过皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; --i, ++j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}