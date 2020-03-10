import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_94 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
        List list = inorderTraversal(n1);
        Utils.print(list);
        Utils.print(inorderTraversal_1(n1));
    }

    // 递归实现
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;

    }
    static void inorderTraversal(TreeNode root,List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left,result);
            result.add(root.val);
            inorderTraversal(root.right,result);
        }
    }

    // 非递归实现
    public static List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = null;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left == null || temp == peek.left) {
                list.add(peek.val);
                temp = stack.pop();
            } else {
                stack.push(peek.left);
                if (peek.right != null) {
                    stack.push(peek.right);
                }
            }
        }
        return list;
    }

}
