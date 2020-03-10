import java.util.Stack;

public class Problem_20 {
    public static void main(String[] args) {
        System.out.println(isValid("{(])}"));
    }

    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if (c == ']' && peek == '['
                || c == '}' && peek == '{'
                || c == ')' && peek == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
