import ds.tree.Tree_1;

import java.util.*;

public class Problem_589 {
    public static void main(String[] args) {
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n3 = new Node(3, Arrays.asList(n5,n6));
        Node n1 = new Node(1,Arrays.asList(n3,n2,n4));
        Utils.print(preorder(n1));
        Utils.print(preorder_1(n1));
    }

    // 递归实现
    public static List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preorder(root,list);
        return list;
    }

    public static void preorder(Node root,List<Integer> result) {
        if(root != null) {
            result.add(root.val);
            if (root.children != null && root.children.size() > 0) {
                root.children.forEach(e -> preorder(e,result));
            }
        }
    }
    public static List<Integer> preorder_1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            list.add(pop.val);
            if (pop.children != null && pop.children.size() > 0) {
                for (int i = pop.children.size() - 1; i >= 0; i--) {
                    stack.push(pop.children.get(i));
                }
            }
        }
        return list;

    }
}
