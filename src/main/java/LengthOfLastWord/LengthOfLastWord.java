package LengthOfLastWord;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("hello world "));
    }
    public int lengthOfLastWord(String s) {
        int cnt = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            cnt++;
        }
        return cnt;
    }
}
