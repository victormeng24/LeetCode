package WordSearch;

public class WordSearch {
    public static void main(String[] args) {
        char[][] a={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(new WordSearch().exist(a,"ABCESEEEFS"));
    }
    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *  
     * <p>
     * 提示：
     * <p>
     * board 和 word 中只包含大写和小写英文字母。
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 1 <= word.length <= 10^3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)
                        && traverse(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean traverse(char[][] board, int i, int j, boolean[][] visited, String word, int k) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) return false;
        visited[i][j] = true;
        if (traverse(board, i + 1, j, visited, word, k + 1) || traverse(board, i - 1, j, visited, word, k + 1)
                || traverse(board, i, j + 1, visited, word, k + 1) || traverse(board, i, j - 1, visited, word, k + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
}
