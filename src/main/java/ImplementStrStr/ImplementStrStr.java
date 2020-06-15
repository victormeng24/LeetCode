package ImplementStrStr;

public class ImplementStrStr {
    public static void main(String[] args) {
        int[] arr = new ImplementStrStr().getNext("abcbc");
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
    /**
     * KMP
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) j = next[j];
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            if (j == needle.length()) return (i - j + 1);
        }
        return -1;
    }

    public int[] getNext(String str) {
        int[] next = new int[str.length() + 1];
        if (next.length > 1)
            next[1] = 0;
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) j = next[j];
            if (str.charAt(i) == str.charAt(j)) j++;
            next[i + 1] = j;
        }
        return next;
    }
}
