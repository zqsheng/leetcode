import java.util.Stack;

public class Problem_71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
    // 未达最优
    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            switch (s) {
                case "":
                case ".":
                case "/":
                    break;
                case "..":
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();
    }
}
