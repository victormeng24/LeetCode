package SudokuSolver;

public class SudokuSolver {
    /**
     * 编写一个程序，通过已填充的空格来解决数独问题。
     * <p>
     * 一个数独的解法需遵循如下规则：
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 空白格用 '.' 表示。
     * <p>
     * <p>
     * <p>
     * 一个数独。
     * <p>
     * <p>
     * <p>
     * 答案被标成红色。
     * <p>
     * Note:
     * <p>
     * 给定的数独序列只包含数字 1-9 和字符 '.' 。
     * 你可以假设给定的数独只有唯一解。
     * 给定数独永远是 9x9 形式的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sudoku-solver
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9 for each cell
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char c) {
        //Check colum
        for (int row = 0; row < 9; row++)
            if (board[row][j] == c)
                return false;

        //Check row
        for (int col = 0; col < 9; col++)
            if (board[i][col] == c)
                return false;

        //Check 3 x 3 block
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if (board[row][col] == c)
                    return false;
        return true;
    }
}
