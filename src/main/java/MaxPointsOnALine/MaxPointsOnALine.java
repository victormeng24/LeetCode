package MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] lines = {{0, 0}, {94911151, 94911150}, {94911152, 94911151}};
        System.out.println(new MaxPointsOnALine().maxPoints(lines));
    }

    /**
     * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [[1,1],[2,2],[3,3]]
     * 输出: 3
     * 解释:
     * ^
     * |
     * |        o
     * |     o
     * |  o  
     * +------------->
     * 0  1  2  3  4
     * 示例 2:
     * <p>
     * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出: 4
     * 解释:
     * ^
     * |
     * |  o
     * |     o        o
     * |        o
     * |  o        o
     * +------------------->
     * 0  1  2  3  4  5  6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        Map<Double, Integer> map = new HashMap<>();
        int maxCount = 1;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int duplicateNum = 1;
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                double slope = 0.0;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicateNum++;
                    continue;
                } else if (points[i][0] == points[j][0]) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = 1.0 * (points[i][0] - points[j][0]) / (points[i][1] - points[j][1]) + 0.0;
                }
                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);
            }
            if (map.size() == 0) {
                maxCount = Math.max(duplicateNum, maxCount);
            } else {
                for (int val : map.values()) {
                    maxCount = Math.max(duplicateNum + val, maxCount);
                }
            }
        }
        return maxCount;
    }
}
