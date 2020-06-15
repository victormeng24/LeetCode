package ReverseVowelsOfString;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("Aa"));
    }

    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "hello"
     * 输出: "holle"
     * 示例 2:
     * <p>
     * 输入: "leetcode"
     * 输出: "leotcede"
     * 说明:
     * 元音字母不包含字母"y"。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            while (begin < end && !isVowel(arr[begin])) {
                begin++;
            }
            while (begin < end && !isVowel(arr[end])) {
                end--;
            }
            if (begin < end) {
                char tmp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = tmp;
            }
            begin++;
            end--;
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o'
                || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
