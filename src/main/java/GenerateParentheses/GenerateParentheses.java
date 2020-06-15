package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> list = new GenerateParentheses().generateParenthesis(3);
        System.out.println(list);
    }
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：n = 3
     * 输出：[
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        traversal(0, 0, n, "", result);
        return result;
    }

    public void traversal(int left, int right, int n, String str, List<String> list) {
        if (left > n || right > n) return;
        if (left == right && left == n) {
            list.add(str);
        }
        if (left > right) {
            traversal(left, right + 1, n, str + ")", list);
        }
        traversal(left + 1, right, n, str + "(", list);
    }
}
