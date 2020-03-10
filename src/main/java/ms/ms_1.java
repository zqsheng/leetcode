package ms;

import java.util.Stack;

/**
 * 最小栈
 */
public class ms_1 {

    private static class MinStack{
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public Integer push(Integer x) {
            return stack.push(x);
        }
        public Integer pop() {
            return stack.pop();
        }

        public Integer min() {
            return null;
        }
    }

}
