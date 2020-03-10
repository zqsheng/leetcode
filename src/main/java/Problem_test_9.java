import java.util.Stack;

public class Problem_test_9 {
    static class CQueue {

        Stack<Integer> stack1 ;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                if(!stack2.isEmpty()) {
                    return stack2.pop();
                }
            }
            return  -1;
        }
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(2);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue.deleteHead());

        }
    }
}
