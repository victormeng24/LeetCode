package NumberOfClosedIslands;

public class NumberOfClosedIslands {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println(new NumberOfClosedIslands().closedIsland(grid));
    }

    /**
     * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
     * <p>
     * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
     * <p>
     * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
     * <p>
     * 请返回封闭岛屿的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
     * 输出：2
     * 解释：
     * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：grid = [[1,1,1,1,1,1,1],
     *              [1,0,0,0,0,0,1],
     *              [1,0,1,1,1,0,1],
     *              [1,0,1,0,1,0,1],
     *              [1,0,1,1,1,0,1],
     *              [1,0,0,0,0,0,1],
     * [1,1,1,1,1,1,1]]
     * 输出：2
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= grid.length, grid[0].length <= 100
     * 0 <= grid[i][j] <=1
     * 通过次数4,381提交次数7,484
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-closed-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    cnt += dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return 0;
        }
        int res = 1;
        if (grid[i][j] == 0) {
            grid[i][j] = -1;
            res = Math.min(res, dfs(grid, i + 1, j));
            res = Math.min(res, dfs(grid, i - 1, j));
            res = Math.min(res, dfs(grid, i, j + 1));
            res = Math.min(res, dfs(grid, i, j - 1));
        }
        return res;
    }
}
