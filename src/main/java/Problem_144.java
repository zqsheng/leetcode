import ds.tree.Tree_1;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_144 {
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
        List list = preorderTraversal(n1);
        Utils.print(list);
        Utils.print(preorderTraversal_1(n1));
    }

    // 递归实现
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;

    }
    static void preorderTraversal(TreeNode root,List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left,result);
            preorderTraversal(root.right,result);
        }
    }
    // 非递归实现
    public static List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

}
