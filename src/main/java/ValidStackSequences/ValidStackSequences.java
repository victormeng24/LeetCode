package ValidStackSequences;

import java.util.Stack;

public class ValidStackSequences {
    public static void main(String[] args) {
        int[] pushed = {2, 1, 0};
        int[] popped = {1, 2, 0};
        System.out.println(new ValidStackSequences().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[i++]) {
                return false;
            }
        }
        return true;
    }
}
