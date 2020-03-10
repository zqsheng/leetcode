package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree_1 {
    public static class Node {
        int val;
        Node left;
        Node right;
        public Node(int x) { val = x; }
    }


    public static void inOrder(Node root) {
        if (root == null) {return;}
        inOrder(root.left);
        System.out.print(root.val + "->");
        inOrder(root.right);
    }
    public static void inOrder1(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                Node pop = stack.pop();
                System.out.print(pop.val + "->");
                p = pop.right;
            }
        }
    }
    public static void preOrder(Node root) {
        if (root == null) {return;}
        System.out.print(root.val + "->");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void preOrder1(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.print(pop.val + "->");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }
    public static void postOrder(Node root) {
        if (root == null) {return;}
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + "->");
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = null;
            while ((node = queue.poll()) != null) {
                System.out.print(node.val + "->");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
//        preOrder(n1);
//        System.out.println("");
//        preOrder1(n1);
//        System.out.println("");
        inOrder(n1);
        System.out.println("");
        inOrder1(n1);
//        postOrder(n1);
//        System.out.println("");
        levelOrder(n1);

    }
}
