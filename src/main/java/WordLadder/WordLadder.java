package WordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     * <p>
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     * <p>
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例 1:
     * <p>
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 输出: 5
     * <p>
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * 返回它的长度 5。
     * 示例 2:
     * <p>
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * 输出: 0
     * <p>
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-ladder
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        if (!wordSet.contains(endWord) || beginWord.length() != endWord.length()) return 0;
        int len = 1;
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
