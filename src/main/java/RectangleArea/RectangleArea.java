package RectangleArea;

public class RectangleArea {
    /**
     * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
     * <p>
     * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入: -3, 0, 3, 4, 0, -1, 9, 2
     * 输出: 45
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rectangle-area
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int totalarea = (C - A) * (D - B) + (G - E) * (H - F);
        int a1 = Math.max(A, E);

        int a2 = Math.min(C, G);

        int b1 = Math.min(D, H);

        int b2 = Math.max(B, F);

        if (a2 <= a1 || b1 <= b2) {

            return totalarea;
        } else return (totalarea - (a2 - a1) * (b1 - b2));
    }
}
