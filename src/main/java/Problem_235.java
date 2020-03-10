import sun.java2d.DisposerTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Problem_235 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode() {}
    }


    // TODO
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        return null;
    }

    private static TreeNode buildBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int layer = getLayer(arr.length);
        int lastNodeCount = (arr.length - (1 << (layer - 1))) + 1;
        int arrIndex = arr.length - 1,popSize = 0;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0;i < (1 << (layer - 1)) - lastNodeCount;i++){
            stack.push(null);
        }
        for (int i = 0; i < lastNodeCount; i++) {
            stack.push(Optional.ofNullable(arr[arr.length - i -  1]).map(e -> new TreeNode(e)).orElse(null));
        }
        arrIndex = arr.length - lastNodeCount;
        for (int i = 0,j = (1 << layer) - 2 ; i < layer - 1; i++) {
            List<TreeNode> list = new ArrayList<>();
            while(!stack.isEmpty()) {
                TreeNode node = null;
                if (j < arr.length) {
                    Integer val = arr[arrIndex--];
                    if (val != null) {
                        node = new TreeNode();
                        node.right = stack.pop();
                        node.left = stack.pop();
                    }
                }
                j--;
                list.add(node);
            }
            list.forEach(e -> stack.push(e));
        }
        return null;
    }

    private static int getLayer(int length) {
        int i = 1;
        while (length > (1 << i) - 1) {
            i++;
        }
        return i;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = buildBinaryTree(arr);
        System.out.println(getLayer(4));

    }

}
